package com.hogwarts.scm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity<Integer> {
    private static final long serialVersionUID = -2963057126108372984L;

    private String name;
    private String description;

    @Override
    public String toString() {
        return "SysRole{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
    }
}
