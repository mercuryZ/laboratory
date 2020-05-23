package com.hogwarts.scm.service;

import com.hogwarts.scm.base.result.Results;
import com.hogwarts.scm.dto.UserDto;
import com.hogwarts.scm.model.SysUser;

public interface UserService {
    SysUser getUser(String username);

    SysUser updateUser(String username, String password);

    Results<SysUser> getAllUserbyPage(Integer offset, Integer limit);

    Results<SysUser> save(SysUser userDto, Integer roleId);

    SysUser getUserByTelephone(String Telephone);
}
