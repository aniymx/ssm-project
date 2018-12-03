package com.itheima.service.impl;

import com.itheima.dao.PermissionDao;
import com.itheima.service.PermissionService;
import com.ithiema.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        List<Permission> permissionList = permissionDao.findAll();
        return permissionList;
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return permissionDao.findOtherPermission(id);
    }
}
