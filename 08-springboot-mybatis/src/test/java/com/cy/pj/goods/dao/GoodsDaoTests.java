package com.cy.pj.goods.dao;
import com.cy.pj.goods.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class GoodsDaoTests {
    @Autowired
    //@Qualifier("goodsDaoImpl")
    private GoodsDao goodsDao;//思考:请问此变量指向的对象是谁?具体类型是什么?
    @Test
    void testFindGoods(){
        List<Goods> list=goodsDao.findGoods();//请问此方法内部的逻辑是怎样的?
        for(Goods g:list){
            System.out.println(g);
        }
       // list.forEach(item->System.out.println()); lambda
    }
}
