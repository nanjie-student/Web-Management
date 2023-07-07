package com.cy.pj.module.controller;

import com.cy.pj.module.pojo.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * 在这个Controller中演示如何将对象转换为json格式字符串,然后响应到客户端
 * 思考:为什么要将数据转换为json
 * 1)json是一种轻量级(解析非常方便)的数据格式:{key:value,key:value,....}
 * 2)json这种数据格式非常适合跨端应用(客户端百花齐放-手机,手表,电视,导航,...)
 */
//@Controller
//@ResponseBody
@RestController //==@Controller+ResponseBody
public class JsonObjectController {
    @RequestMapping("/doConvertResponseToJson")
   // @ResponseBody
    //方法返回值不在是一个view,并告诉spring将响应结果转换为json格式字符串,
    //然后写入到http响应体中,最后传输到客户端.
    public ResponseResult doConvertResponseToJson() {
        ResponseResult r=new ResponseResult();
        r.setCode(200);
        r.setMessage("update ok");
        //new ObjectMapper().writeValueAsString(r);//自己将对象转换为json串
        return r;
    }//当方法的返回值是一个pojo对象,并且方法上有@ResponseBody注解描述,spring mvc会将
    //返回值转换为json格式的字符串响应到客户端.

    @RequestMapping("/doConvertMapToJson")
    //@ResponseBody
    public Map<String,Object> doConvertMapToJson(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","刘德华");
        map.put("state",true);
        return map;
    }

    @RequestMapping("doPrintJson")
    //@ResponseBody
    public void doPrintJson(HttpServletResponse response) throws IOException {
        Map<String,Object> map=new HashMap<>();
        map.put("username","刘德华");
        map.put("state",true);
        //借助第三方jackson中的api将对象转换为json格式字符串
        String jsonStr=new ObjectMapper().writeValueAsString(map);
        //基于servlet中原生的api将字符串响应到客户端
        response.setCharacterEncoding("utf-8");//设置响应数据编码
        //设置响应到客户端的内容类型,并告诉客户端以什么编码进行显示
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(jsonStr);
    }


}
