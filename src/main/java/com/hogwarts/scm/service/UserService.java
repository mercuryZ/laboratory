package com.hogwarts.scm.service;

import com.hogwarts.scm.model.SysUser;

public interface UserService {
    SysUser getUser(String username);
    SysUser updateUser(String username, String password);
}
