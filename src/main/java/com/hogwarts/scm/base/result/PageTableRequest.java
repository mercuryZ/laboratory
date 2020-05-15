package com.hogwarts.scm.base.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageTableRequest implements Serializable {
    private Integer page;
    private Integer limit; // 每页显示的数目
    private Integer offset;

    public void countOffset() {
        if (null == this.page || limit == null) {
            this.offset = 0;
            return;
        }
        this.offset = (this.page - 1) * limit;
    }
}
