package com.cy.pj.category.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;
    private String name;
    private Integer parentId;
    private String remark;
    private Date createdTime;
}
