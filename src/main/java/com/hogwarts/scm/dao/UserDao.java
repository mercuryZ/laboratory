package com.hogwarts.scm.dao;

import com.hogwarts.scm.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    @Select("select * from sys_user t where t.username = #{username}")
    SysUser getUser(String username);

    @Select("select * from sys_user t where t.username = #{username} and t.password = #{password}")
    SysUser updateUser(String username, String password);

    @Select("select count(*) from sys_user t")
    Long countAllUsers();

    @Select("select * from sys_user t order by t.id limit #{startPosition}, #{limit}")
    List<SysUser> getUserbyPage(@Param("startPosition") Integer startPosition, @Param("limit") Integer limit);
}
