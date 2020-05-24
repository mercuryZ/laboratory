package com.hogwarts.scm.service;

import com.hogwarts.scm.base.result.Results;

public interface RoleUserService {
    Results getSysRoleUserByUserId(Integer userId);
}
