package com.itheima.web.controller;

import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import com.ithiema.domain.Permission;
import com.ithiema.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //为角色添加权限 (展示)
    @RequestMapping("findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String id) {
        //获取到role的值,进行关联查询出permission(排他查询)
        //返回List<Permisson>,单个role
        //
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(id);
        //前台需要隐藏域roleid
        modelAndView.addObject("role", role);
        //查询出role没有进行授予的权限
        List<Permission> permissionList = permissionService.findOtherPermission(id);
        modelAndView.addObject("permissionList", permissionList);
        //跳转视图
        modelAndView.setViewName("role-permission-add");
        return modelAndView;

    }

    //为角色添加权限 (执行添加操作)
    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(
            @RequestParam(name = "roleId",required = true)
                    String roleId,@RequestParam(name = "ids",required = true) String[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "role-list";
    }


}
