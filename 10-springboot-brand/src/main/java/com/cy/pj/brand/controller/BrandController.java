package com.cy.pj.brand.controller;

import com.cy.pj.brand.pojo.Brand;
import com.cy.pj.brand.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brand/doFindById/{id}")
    public String doFindById(@PathVariable  Integer id,Model model){
        Brand brand=brandService.findById(id);
        System.out.println("brand="+brand);
        model.addAttribute("brand",brand);
        return "/brand/brand-update";
    }

    @PostMapping("/brand/doUpdateBrand")
    public String doUpdateBrand(Brand brand,Model model){
        System.out.println("update.brand="+brand);
        brandService.updateBrand(brand);
        List<Brand> list=brandService.findBrands(null);
        model.addAttribute("list",list);
        return "brand/brand";
    }

    @PostMapping("/brand/doSaveBrand")
    public String doSaveBrand(@Valid Brand brand, Model model){
        System.out.println("save.brand="+brand);
        brandService.saveBrand(brand);
        List<Brand> list=brandService.findBrands(null);
        model.addAttribute("list",list);
        return "brand/brand";
    }

    @GetMapping("/brand/doAddUI")
    public String doAddUI(){
        return "brand/brand-add";
    }



    @GetMapping("/brand/doDeleteById/{id}")
    public String doDeleteById(@PathVariable Integer id,Model model){
       brandService.deleteById(id);//id值没有是什么原因
       List<Brand> list=brandService.findBrands(null);
       model.addAttribute("list",list);
       return "brand/brand";
    }

    //http://localhost/brand/doFindBrands?name=tcl 传统方式url
    //http://localhost/brand/doFindBrands/tcl rest风格url
    //rest风格(一种软件架构编码风格)的url定义
    //其语法为:a/b/{c}/d/{e},在url可以定义变量,这个变量需要使用{}括起来
    //rest风格可以更好实现跨平台
    //@PathVariable 注解用于修饰方法参数,目的是告诉spring mvc,参数的值来自url

    @GetMapping(value={"/brand/doFindBrands","/brand/doFindBrands/{name}"})
    public String doFindBrands(@PathVariable(required = false) String name, Model model) {
        List<Brand> list=brandService.findBrands(name);
        model.addAttribute("list", list);
        return "brand/brand";//第一个brand为目录,第二brand为view name
    }//所有与数据相关的问题,一定要学会去跟踪你的数据?
    //例如:
    //1)客户端向服务端提交的数据,在服务端没有收到?(一定要看客户端提交数据的方式与服务端获取数据的方式)
    //2)服务端向客户端响应数据时,假如客户端没有收到?(先检测服务端响应数据之前的数据是什么样子的)
}
