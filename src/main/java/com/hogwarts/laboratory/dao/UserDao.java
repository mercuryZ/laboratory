package com.hogwarts.laboratory.dao;


import com.hogwarts.laboratory.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {
    @Select("select * from sys_user t where t.username = #{username}")
    SysUser getUser(String username);

    @Select("select * from sys_user t where t.username = #{username} and t.password = #{password}")
    SysUser updateUser(String username, String password);
}
