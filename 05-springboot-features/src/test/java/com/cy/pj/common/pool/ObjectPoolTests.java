package com.cy.pj.common.pool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectPoolTests {
    //bean池中还没有对象时,会创建对象,会存储到bean池,便于对象的重用.
    @Autowired
    private ObjectPool objectPool01;

    @Autowired
    private ObjectPool objectPool02;

    @Test
    void testObjectPool(){
        System.out.println(objectPool01==objectPool02);
    }

}
