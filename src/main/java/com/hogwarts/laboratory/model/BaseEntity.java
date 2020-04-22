package com.hogwarts.laboratory.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    private static final long serialVersionUID = 2692616834857587804L;
    private ID id;
    private Date createTime = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime = new Date();
}