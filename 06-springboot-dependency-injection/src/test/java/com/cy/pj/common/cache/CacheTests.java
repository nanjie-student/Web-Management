package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTests {

    @Autowired
    @Qualifier("softCache")//这里的名字为bean的名字
    private Cache cache;//has a

    @Test
    void testCache(){
        System.out.println("cache="+cache);
    }
    
}
