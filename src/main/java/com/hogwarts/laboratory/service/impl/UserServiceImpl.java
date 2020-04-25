package com.hogwarts.laboratory.service.impl;

import com.hogwarts.laboratory.dao.UserDao;
import com.hogwarts.laboratory.model.SysUser;
import com.hogwarts.laboratory.service.UserService;
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
    public int updateUser(String username, String password) {
       return userDao.updateUser(username, password);
    }
}
