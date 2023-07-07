package com.cy.pj.category.service.impl;

import com.cy.pj.category.dao.CategoryDao;
import com.cy.pj.category.pojo.Category;
import com.cy.pj.category.service.CategoryService;
import com.cy.pj.common.annotation.RequiredCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger log= LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    private CategoryDao categoryDao;

    @RequiredCache //此注解描述的方法为切入点方法
    @Override
    public List<Category> findCategorys() {
        System.out.println("CategoryServiceImpl.findCategorys");
        //long t1=System.currentTimeMillis();
        // Get Data from Cache
        List<Category> list=categoryDao.findCategorys();
        //put Data to cache
        //long t2=System.currentTimeMillis();
        //log.info("execute time : {}",(t1-t1));
        return list;
    }
}
