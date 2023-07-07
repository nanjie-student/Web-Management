package com.cy.pj.goods.dao;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
       /**从数据库查询商品信息,一行记录映射为内存中的一个map对象,
        * map中的key为每行中的字段名,map中的value为每行中字段名的值,
        *多行记录就映射到内存中的多个map,然后将多个map存储到list集合*/
       List<Map<String,Object>> findGoods();//can
}
