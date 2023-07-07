package com.cy.pj.goods.pojo;
import java.util.Date;

/**
 * 定义商品模块的pojo对象,基于此对象封装从数据库
 * 查询到的商品信息.
 */
public class Goods {//商品类型
    private Long id;
    private String name;
    private String remark;
    private Date createdTime;
    //alt+insert


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
