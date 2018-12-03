package com.itheima.dao;

import com.ithiema.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role where id in (select roleid from users_role where userid = #{id})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findById"))
    })
    Role findRoleById(String id);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id not in(select roleid from users_role where userId = #{id})")
    List<Role> findOtherRole(String id);

    @Select("select * from role where id =#{id}")
    Role findById(@Param("id") String id);


    @Insert("insert into role_permission (permissionId,roleId) values(#{id},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("id") String id);
}
