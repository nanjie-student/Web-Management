package com.cy.pj.module.controller;

import com.cy.pj.module.pojo.RequestParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 在此controller中演示请求参数数据的处理
 */
@RestController
public class ParamObjectController {

    //http://localhost/doParam01?name=mvc
    //基于直接量参数来接收请求中的参数数据,我们定义的方法参数名应与请求中的参数名相同
    @GetMapping("/doParam01")//这个注解描述的方法只能处理Get类型的请求
    //@ResponseBody
    //@RequestMapping(value="/doParam01",method = RequestMethod.GET)
    public String doMethodParam(String name){
        return "request params "+name;
    }

    //http://localhost/doParam02?name=mvc
    @GetMapping("/doParam02")
    public String doMethodParam(RequestParameter param){
        //当使用pojo对象作为方法参数接收客户端参数数据时,pojo对象中应该提供
        //与客户端参数名匹配的set方法
       // System.out.println(param);
        return "request params "+param.toString();
    }

    //http://localhost/doParam03?name=mvc
    @GetMapping("/doParam03")
    public String doMethodParam(@RequestParam  Map<String,Object> param){
        //当方法参数是map类型,而且希望基于map接收客户端请求参数,
        //则需要使用指定注解对map进行描述,例如@RequestParam
        //但是,使用map作为方法参数接收客户端请求数据不太严谨(客户端可以传递任意参数).

        return "request params "+param.toString();
    }


}