package com.itheima.service;

import com.ithiema.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findOtherPermission(String id);
}
