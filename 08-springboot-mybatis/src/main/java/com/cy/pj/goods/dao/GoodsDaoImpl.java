package com.cy.pj.goods.dao;
import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //描述数据层实现类,用于交给spring管理
public class GoodsDaoImpl implements GoodsDao{//bean的名字goodsDaoImpl
    @Autowired
    private SqlSession sqlSession;//Template

    @Override
    public List<Goods> findGoods() {
        //????????? (回顾mybatis基础)
        //return sqlSession.selectList("com.cy.pj.goods.dao.GoodsDao.findGoods");//广州
        return sqlSession.getMapper(GoodsDao.class).findGoods();//佛山,天津
    }
}