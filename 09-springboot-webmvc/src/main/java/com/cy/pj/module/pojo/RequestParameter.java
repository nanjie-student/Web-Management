package com.cy.pj.module.pojo;
/**基于此对象在服务端封装客户端的请求参数值*/
public class RequestParameter {//pojo
    private String name;
    //..........

    public String getName() {
        return name;
    }

    public void setN(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestParameter{" +
                "name='" + name + '\'' +
                '}';
    }
}
