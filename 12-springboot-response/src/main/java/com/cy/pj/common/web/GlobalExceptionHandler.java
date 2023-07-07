package com.cy.pj.common.web;

import com.cy.pj.common.pojo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseResult doHandleArithmeticException(ArithmeticException e){
        e.printStackTrace();
        return new ResponseResult(e);//封装异常信息
    }
    //...


}
