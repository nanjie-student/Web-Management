package com.cy.pj.arithmetic.controller;

import com.cy.pj.arithmetic.service.ArithemeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArithmeticController{

    //Controller类内部的异常处理方法 (谁来调用它?)\
    //@ExceptionHandler注解描述的方法为异常处理方法
    //@ExceptionHandler注解内部定义的异常类型为它描述的方法可以处理的异常类型
//    @ExceptionHandler({ArithmeticException.class})
//    @ResponseBody
//    public String doHandleArithmeticException(ArithmeticException e){
//        return "the exception msg is "+e.getMessage();
//    }

    @ResponseBody
    @RequestMapping("/doCompute/{n1}/{n2}")
    public String doCompute(@PathVariable  Integer n1,
                            @PathVariable Integer n2){
//        try {
            Integer result = n1 / n2;//假如没有处理异常,这里的异常抛给谁?DispatcherServlet
            return "The Result is "+result;
//        }catch (ArithmeticException e){
//            e.printStackTrace();
//            return "计算过程中出现了异常,具体信息为:"+e.getMessage();
//        }
        //假如控制逻辑对象中,大量这种方式的异常处理,会导致大量重复代码出现.
    }

    @Autowired
    private ArithemeticService arithemeticService;

    @ResponseBody
    @RequestMapping("/doSum/{nums}")
    public String doSum(@PathVariable Integer ...nums){
        return "求和结果为"+arithemeticService.sum(nums);
    }


}
