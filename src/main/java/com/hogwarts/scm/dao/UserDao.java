package com.hogwarts.scm.dao;

import com.hogwarts.scm.model.SysUser;
import org.apache.ibatis.annotations.*;
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

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sys_user(username, password, nickname, headImgUrl, " +
            "telephone, email, birthday, sex, status, createTime, updateTime) " +
            "values(#{username}, #{password}, #{nickname}, #{headImgUrl} ," +
            "#{telephone}, #{email}, #{birthday}, #{sex}, #{status}, now(), now() )")
    int save(SysUser user);

    @Select("select * from sys_user t where t.telephone = #{telephone}")
    SysUser getUserByTelephone(String telephone);
}
