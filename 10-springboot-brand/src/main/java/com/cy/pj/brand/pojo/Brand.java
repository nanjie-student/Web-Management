package com.cy.pj.brand.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Getter
@Setter
@ToString
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Brand {
    private Integer id;
    @NotEmpty(message="品牌名不能为空")
    private String name;
    private String remark;
    private Date createdTime;
}
