package com.hogwarts.laboratory.model;

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
    private String phone;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer status;
    private String mark;

    public interface Status {
        int DISABLED = 0;
        int VALID = 1;
        int LOCKED = 2;
    }
}
