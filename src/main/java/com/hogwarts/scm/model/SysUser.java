package com.hogwarts.scm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data // 使用@Data注解实现set和get方法
@EqualsAndHashCode(callSuper = true) // 完全继承父类
public class SysUser extends BaseEntity<Long>{
    private static final long serialVersionUID = -6017947516314959347L;
    private String username;
    private String password;
    private String nickname;
    private String headImgUrl;
    private String telephone;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
    private Integer status;

    public interface Status {
        int DISABLED = 0;
        int VALID = 1;
        int LOCKED = 2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
