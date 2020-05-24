package com.hogwarts.scm.service.impl;

import com.hogwarts.scm.base.result.Results;
import com.hogwarts.scm.dao.RoleUserDao;
import com.hogwarts.scm.model.SysRoleUser;
import com.hogwarts.scm.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserDao roleUserDao;

    @Override
    public Results getSysRoleUserByUserId(Integer userId) {
        SysRoleUser sysRoleUser = roleUserDao.getSysRoleUserByUserId(userId);
        if(sysRoleUser != null) {
            return Results.success(sysRoleUser);
        }else {
            return Results.success();
        }
    }
}
