package com.hogwarts.scm.dao;

import com.hogwarts.scm.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {
    @Select("select * from sys_role t")
    List<SysRole> getAllRoles();
}
