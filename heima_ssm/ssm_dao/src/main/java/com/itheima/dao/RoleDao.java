package com.itheima.dao;

import com.ithiema.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role where id in (select roleid from users_role where userid = #{id})")
    Role findRoleById(String id);

    @Select("select * from role")
    List<Role> findAll();
}
