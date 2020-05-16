package com.hogwarts.scm.service.impl;

import com.hogwarts.scm.base.result.Results;
import com.hogwarts.scm.dao.RoleDao;
import com.hogwarts.scm.model.SysRole;
import com.hogwarts.scm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Results<SysRole> getAllRoles() {
        return Results.success(10, roleDao.getAllRoles());
    }
}
