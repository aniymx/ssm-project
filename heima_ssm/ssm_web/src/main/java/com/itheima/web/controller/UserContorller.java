package com.itheima.web.controller;

import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import com.ithiema.domain.Role;
import com.ithiema.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserContorller {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAll();
        modelAndView.addObject("userList", userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("save.do")
    public String saveUser(UserInfo userInfo) {
        userService.saveUser(userInfo);
        return "redirect:findAll.do";
    }
//用户详情
    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) {

        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("findByIdForUpdate.do")
    public ModelAndView findByIdForUpdate(@RequestParam(name = "id", required = true) String id) {

        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userService.findById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-update");
        return modelAndView;
    }

    @RequestMapping("update.do")
    public String updateUser(UserInfo userInfo) {

        System.out.println(userInfo);
        userService.updateUser(userInfo);
        return "redirect:findAll.do";
    }

    //
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        List<Role> roleList = roleService.findOtherRole(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    //点击保存按钮执行操作
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(String userId, String[] ids) {

        for (String s : ids) {
            System.out.println(s);
        }
        System.out.println(userId);

        userService.addRoleToUser(userId, ids);
        return "redirect:findAll.do";
    }


 /*   @RequestMapping("findOtherRole.do")
    public ModelAndView findOtherRole(String id) {
        List<Role> roleList = roleService.findOtherRole(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;

    }*/
}
