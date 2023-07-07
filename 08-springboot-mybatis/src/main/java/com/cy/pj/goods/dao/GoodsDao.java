package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//此注解用于描述mybatis框架中的数据逻辑层接口,用于告诉mybatis框架此接口实现类
//由mybatis框架创建(底层基于JDK创建其代理),此类型的对象会交给spring管理.
@Mapper
public interface GoodsDao {//com.cy.pj.goods.dao.GoodsDao
      /**
       * 定义查询商品信息的规范(Can)
       * @return
       * 思考在接口的实现类中,此方法内部会做什么?基于sqlSession实现数据访问.
       */
      List<Goods>  findGoods();
}
//黑科技(将底层过程做了具体封装)