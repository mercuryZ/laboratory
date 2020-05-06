package com.hogwarts.laboratory.service;

import com.hogwarts.laboratory.model.SysUser;

public interface UserService {
    SysUser getUser(String username);
    SysUser updateUser(String username, String password);
}
