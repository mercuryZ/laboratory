package com.hogwarts.laboratory.dao;


import com.hogwarts.laboratory.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {
    @Select("select * from sys_user t where t.username = #{username}")
    SysUser getUser(String username);

    @Update("update sys_user set password = #{password} where username = #{username}")
    int updateUser(String username, String password);
}
