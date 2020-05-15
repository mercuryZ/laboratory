package com.hogwarts.scm.service.impl;

import com.hogwarts.scm.base.result.Results;
import com.hogwarts.scm.dao.UserDao;
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
}
