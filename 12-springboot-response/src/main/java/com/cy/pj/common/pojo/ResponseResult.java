package com.cy.pj.common.pojo;

/**封装服务端响应到客户端结果(控制逻辑对象中),基于此对象
 * 定义响应规范,便于后续在客户端做统一处理*/
public class ResponseResult {
    /**响应状态码*/
    private Integer state=1;//1 表示ok,0表示error
    /**响应状态码对应的具体信息*/
    private String message="ok";
    /**响应数据(一般是查询时获取到的正确数据)*/
    private Object data;

    public ResponseResult(){}
    public ResponseResult(String message){//new ResponseResult("delete ok");
        this.message=message;//
    }
    public ResponseResult(Object data){
        this.data=data;
    }
    public ResponseResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }
    //.......
    //.......


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
