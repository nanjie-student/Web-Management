package com.cy.pj.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 业务场景?
 * 客户端向服务端发起一个请求,服务端处理完请求以后,直接将响应数据封装到model中,然后和
 * view一起响应到客户端.
 * 问题分析?
 * 1)在这种应用实现过程中,假如controller处理数据的时间比较长,会直接影响响应
 * 页面的响应时长.给用户带来不好的用户体验.
 * 2)在当前大前端高速发展的过程中,各种端百花齐放,有些端可能只需要服务端的数据,
 * 但不需要服务端的页面,而我们将数据和页面绑定在一起返回,这些做法扩展性不好.
 *
 * 说明:很多中小型企业内部的管理系统直接就是SpringBoot+Thymyleaf技术进行实现.
 *
 */
@Controller
public class ModelViewController {
    /**处理完客户端请求以后,将响应结果封装到ModelAndView对象*/
    @RequestMapping("/doModelAndView01")
    public String doModelAndView(Model model){//model底层通过map存储数据
        model.addAttribute("username", "jason");
        model.addAttribute("state", true);
        return "view";//viewname
        //我们这里的响应结果,在spring mvc中会帮我们封装为ModelAndView对象
    }
    @RequestMapping("/doModelAndView02")
    public ModelAndView doModelAndView(ModelAndView mv) throws InterruptedException {
        Thread.sleep(3000);//模拟耗时操作
        //ModelAndView mv=new ModelAndView();
        mv.addObject("username", "jason");
        mv.addObject("state", true);
        mv.setViewName("view");
        return mv;
    }
}
