package com.hogwarts.scm.service;

import com.hogwarts.scm.base.result.Results;
import com.hogwarts.scm.model.SysRole;

public interface RoleService {

    public Results<SysRole> getAllRoles();
}
