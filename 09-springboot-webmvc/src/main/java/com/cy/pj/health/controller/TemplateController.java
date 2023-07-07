package com.cy.pj.health.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller //bean 对象
public class TemplateController {//在spring mvc中这个对象称之为handler(处理器)
    //访问:http://localhost/doTemplateUI
    /**定义一个处理doTemplateUI请求的方法*/
    @RequestMapping("doTemplateUI") // @RequestMapping用于定义url请求的映射
    public String doTemplateUI(){//这个方法是由谁调用?如何调用?
        return "default";//view name (视图名)
        //1)这个名字返回给谁了?方法的调用者(这里调用者是谁-DispatcherServlet)
        //2)DispatcherServlet拿到view name以后做什么?(交给视图解析器进行解析->前缀,后缀,数据)
        //3)DispatcherServlet将拿到的view解析结果响应到客户端(/templates/default.html)
    }
}
