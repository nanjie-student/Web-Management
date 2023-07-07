package com.cy.pj.common.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class DataSourceTests {
    //在java中所有连接池必须遵守dataSource规范的设计
    //可以通过DataSource获取具体的连接池对象.
    @Autowired
    private DataSource dataSource;//此变量指向的对象是谁?(HikariDataSource),你怎么知道的?
    @Test
    void testGetConnection() throws SQLException {
        System.out.println(dataSource.getClass().getName());
        Connection conn1=dataSource.getConnection();//从池中借取一个连接
        //.....
        conn1.close();//将连接还回池中
    }
}
