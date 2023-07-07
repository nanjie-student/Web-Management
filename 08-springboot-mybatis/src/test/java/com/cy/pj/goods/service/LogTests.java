package com.cy.pj.goods.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogTests {
    private static final Logger log= LoggerFactory.getLogger(LogTests.class);
    @Test
    void testLogLevel(){
        //测试日志级别,在springboot中默认为Info,
        //具体配置可以在springboot配置文件中进行级别配置: logging.level
        log.trace("log.level=trace");//调试阶段
        log.debug("log.level=debug");//调试阶段
        log.info("log.level=info");
        log.warn("log.level=warn");
        log.error("log.level=error");
        //.......
    }
}
