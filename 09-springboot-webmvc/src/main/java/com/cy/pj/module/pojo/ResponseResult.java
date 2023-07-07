package com.cy.pj.module.pojo;
/**基于此对象封装响应结果*/
public class ResponseResult {
    /**响应状态码*/
    private Integer code;//500,404,....
    /**响应信息*/
    private String message;

    /**此方法会在将对象转换为json字符串时调用*/
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
