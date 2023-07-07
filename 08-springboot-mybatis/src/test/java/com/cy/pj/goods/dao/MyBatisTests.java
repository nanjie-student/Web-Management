package com.cy.pj.goods.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Connection;
@SpringBootTest
public class MyBatisTests {
    //mybatis框架提供的一个会话对象(负责实现与数据库的会话)
    //mybatis中此对象的创建是通过SqlSessionFactory对象创建的
    @Autowired
    private SqlSession sqlSession;//(此对象由spring完成值的注入)
    @Test
    void testGetConnection(){
        Connection conn=
        sqlSession.getConnection();//请问这里的连接从哪里来?(连接池)
        System.out.println("conn="+conn);
    }
}
