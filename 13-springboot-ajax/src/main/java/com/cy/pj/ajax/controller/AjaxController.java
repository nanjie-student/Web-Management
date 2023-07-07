package com.cy.pj.ajax.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AjaxController {
    /**假设这个是用于存储数据的数据库*/
    private List<Map<String,Object>> dbList=new ArrayList<>();

    public AjaxController(){
        Map<String,Object> map=new HashMap<>();
        map.put("id","100");
        map.put("name","家用电器");
        map.put("parentId",null);//parentId为null则表示它是1级分类
        map.put("remark","电器相关等");
        map.put("createdTime",new Date());
        dbList.add(map);
    }

    @GetMapping("/doAjaxGet")
    public List<Map<String,Object>> doAjaxGet(){
        //throw new RuntimeException("Get Request Error");
        return dbList;
    }
    @PostMapping("/doAjaxPost")
    public String doAjaxPost(@RequestParam Map<String,Object> map){
        map.put("createdTime",new Date());
        dbList.add(map);
        return "save ok";
    }
    @DeleteMapping("/doAjaxDelete")
    public String doAjaxDelete(String id){
        //获取迭代器对象,然后迭代list集合,找到id对应的元素,进行删除操作
        Iterator it=dbList.iterator();
        while(it.hasNext()){
            Map<String,Object> map=(Map<String,Object>)it.next();
            if(map.get("id").equals(id)){
                //dbList.remove(map);//这样删除会出现并发删除异常
                it.remove();//通过迭代器执行删除操作
            }
        }
        return "delete ok";
    }
    @PutMapping("/doAjaxUpdate")
    public String doAjaxUpdate(@RequestParam Map<String,Object> updateMap){
        Iterator it=dbList.iterator();
        while(it.hasNext()){
            Map<String,Object> map=(Map<String,Object>)it.next();
            if(map.get("id").equals(updateMap.get("id"))){
               map.put("name",updateMap.get("name"));
               map.put("remark",updateMap.get("remark"));
            }
        }
       return "update ok";
    }
    @CrossOrigin//@CrossOrigin注解描述的方法支持跨域访问
    @RequestMapping("/doAjaxStart")
    public String doAjaxStart() throws InterruptedException {
        //Thread.sleep(5000);
        return "Response Result Of Ajax Get Request 01 ";
    }

}
