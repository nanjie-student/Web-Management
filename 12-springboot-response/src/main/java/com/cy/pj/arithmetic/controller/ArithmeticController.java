package com.cy.pj.arithmetic.controller;

import com.cy.pj.common.pojo.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArithmeticController {

    @RequestMapping("/doCompute/{n1}/{n2}")
    public ResponseResult doCompute(@PathVariable  Integer n1, @PathVariable Integer n2){
        int result=n1/n2;
        return new ResponseResult("计算结果为:"+result);
    }
}
