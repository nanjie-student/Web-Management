package com.cy.pj.common.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheServiceTests {
    @Autowired
    private CacheService cacheService;

    @Test
    void testCacheService(){
        System.out.println("cacheService="+cacheService);//null
    }
}
