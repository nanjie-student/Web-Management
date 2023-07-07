package com.cy.pj.common.pool;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**构建一个对象池类型,将此类型的对象交给spring管理*/
//@Lazy //spring框架提供的一个用于定义延迟加载特定的一个注解
///"singleton作用域的类的同名实例在内存中只能有一份,这样的实例会存储到池中"
@Scope("prototype")//"prototype为多例作用域,对象何时需要何时创建,不会存储到池"
//@Component("ol")//这里的ol为bean的名字
@Component//bean的名字为"objectPool"
public class ObjectPool {//bean的名字默认为类名,首字母小写.例如"objectPool"
     //byte[]array=new byte[1024*1024*10];
     /**定义无参数构造函数,其目的是监控spring框架何时构建此类的对象*/
     public ObjectPool(){
         System.out.println("ObjectPool()");
     }
     @PostConstruct //生命周期初始化方法,构造方法执行结束执行
     public void init(){
        System.out.println("init()");
     }

     @PreDestroy//生命周期销毁方法,对象从容器池销毁之前
     public void destory(){
        System.out.println("destory()");
     }
}
