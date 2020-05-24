package com.hogwarts.scm.service.impl;

import com.hogwarts.scm.base.result.Results;
import com.hogwarts.scm.dao.RoleUserDao;
import com.hogwarts.scm.dao.UserDao;
import com.hogwarts.scm.dto.UserDto;
import com.hogwarts.scm.model.SysRole;
import com.hogwarts.scm.model.SysRoleUser;
import com.hogwarts.scm.model.SysUser;
import com.hogwarts.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleUserDao roleUserDao;

    @Override
    public SysUser getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public SysUser updateUser(String username, String password)   {
        return userDao.updateUser(username, password);

    }

    @Override
    public Results<SysUser> getAllUserbyPage(Integer offset, Integer limit) {
        return Results.success(userDao.countAllUsers().intValue(), userDao.getUserbyPage(offset, limit));
    }

    @Override
    public Results<SysUser> save(SysUser user, Integer roleId) {
        if(roleId!= null) {
            // save to user
            userDao.save(user);
            SysRoleUser sysRoleUser = new SysRoleUser();
            sysRoleUser.setRoleId(roleId);
            sysRoleUser.setUserId(user.getId().intValue());
            roleUserDao.save(sysRoleUser);
            return Results.success();
        }
        return Results.failure();
    }

    @Override
    public SysUser getUserByTelephone(String telephone) {
        return userDao.getUserByTelephone(telephone);
    }

    @Override
    public SysUser getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
