package com.cy.pj.brand.dao;

import com.cy.pj.brand.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BrandDaoTests {
    @Autowired
    private BrandDao brandDao;

    @Test
    void testDeleteById(){
        int rows=brandDao.deleteById(10);
        System.out.println("rows="+rows);
    }

    @Test
    void testFindBrands(){
        List<Brand> list=brandDao.findBrands("小米");
        for(Brand b:list){
            System.out.println(b.toString());//默认调用对象的toString()方法
        }
    }
}
