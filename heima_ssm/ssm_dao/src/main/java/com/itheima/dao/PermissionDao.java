package com.itheima.dao;

import com.ithiema.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionid from role_permission where roleid=#{id})")
    List<Permission> findById(String id);

    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url}) ")
    void save(Permission permission);
//查询当前role中没有的权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(@Param("roleId") String roleId);
}
