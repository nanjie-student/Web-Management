package com.cy.pj.goods.service;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 业务逻辑对象?
 * 1)核心业务
 * 2)拓展业务(日志记录)
 * 问题?
 * 1)项目中的日志记录用的什么API? SLF4J (Simple Logging Facade for Java)
 * 2)为什么使用此API? (这组API定义了日志的规范-程序中建议耦合规范->其目的提高其可扩展性)
 * 3)这组API的具体实现,你在项目中用的是谁?(ch.qos.logback.classic.Logger)
 * 4)你为什么不用log4j?(异步情况下,logback性能要比log4j好,SpringBoot内置就是logback)
 * 5)你的项目中的日志是同步写还是异步写?(大部分异步,提高其用户体验)
 * 6)你了解日志的级别吗?(日志的输出级别-trace<debug<info<error....)
 */
@Service
public class GoodsServiceImpl implements  GoodsService{
    private static final Logger log= LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> findGoods() {
        long t1=System.currentTimeMillis();
        List<Goods> list=goodsDao.findGoods();
        long t2=System.currentTimeMillis();
        //System.out.println("t2-t1:"+(t2-t1));
        System.out.println(log.getClass().getName());
        log.info("execute time:{}",t2-t1);//这里的{}表示占位符
        return list;
    }
}
