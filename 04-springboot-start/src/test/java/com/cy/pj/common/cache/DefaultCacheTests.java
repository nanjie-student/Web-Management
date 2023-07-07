package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //此注解描述的类为springboot工程中的单元测试类
public class DefaultCacheTests {
    //has a
    @Autowired //此注解用于告诉spring请按指定规则为此属性赋值
    private DefaultCache defaultCache;

    @Test
    void testDefaultCache(){
        System.out.println(defaultCache.toString());
    }
}
