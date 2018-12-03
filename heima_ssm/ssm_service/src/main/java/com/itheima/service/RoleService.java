package com.itheima.service;

import com.ithiema.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role>  findAll();

    void save(Role role);

    List<Role> findOtherRole(String id);

    Role findById(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
