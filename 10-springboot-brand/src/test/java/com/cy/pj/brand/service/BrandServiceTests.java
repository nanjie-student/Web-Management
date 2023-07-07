package com.cy.pj.brand.service;

import com.cy.pj.brand.pojo.Brand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BrandServiceTests {
    @Autowired
    private BrandService brandService;//NoSuchBeanDefinitionException

    @Test
    void testDeleteById(){
        int rows=brandService.deleteById(10);
        Assertions.assertNotEquals(-1,rows);
        System.out.println("rows="+rows);
    }

    @Test
    void testFindBrands(){
        List<Brand> list=brandService.findBrands("小米");
        System.out.println(list.size());
        Assertions.assertEquals(1, list.size());//断言测试(实际值和期望值不等则抛出异常)
        System.out.println("test ok");
        for (Brand b:list){
            System.out.println(b);
        }
        //list.forEach(brand->System.out.println(brand));//jdk 1.8 lambda 表达式
        //list.forEach(System.out::println);//jdk 1.8 方法引用
    }

}
