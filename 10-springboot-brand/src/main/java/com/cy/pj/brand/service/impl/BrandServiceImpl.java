package com.cy.pj.brand.service.impl;

import com.cy.pj.brand.dao.BrandDao;
import com.cy.pj.brand.pojo.Brand;
import com.cy.pj.brand.service.BrandService;
import com.cy.pj.common.annotation.ClearCache;
import com.cy.pj.common.annotation.RequiredCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {
    //@Slf4j  注解描述类时,会在.java编译成.class时,自动创建一个log对象
    //private static final Logger log=//这里的实现在springboot中默认选择的是logback
    //LoggerFactory.getLogger(BrandServiceImpl.class);
    @Autowired
    private BrandDao brandDao;

    @RequiredCache
    @Override
    public List<Brand> findBrands(String name) {
        long t1=System.currentTimeMillis();
        List<Brand>  list= brandDao.findBrands(name);
        long t2=System.currentTimeMillis();
        log.info("time:{}",t2-t1);
        return list;
    }

    @Override
    public Brand findById(Integer id) {
        //.....
        return brandDao.findById(id);
    }

    @ClearCache
    @Override
    public int updateBrand(Brand brand) {
        //.....
        return brandDao.updateBrand(brand);
    }

    @ClearCache
    @Override
    public int saveBrand(Brand brand) {
        int rows=brandDao.insertBrand(brand);
        return rows;
    }

    @ClearCache
    @Override
    public int deleteById(Integer id) {
        //1.参数校验
        //2.执行删除逻辑
        int rows=brandDao.deleteById(id);
        //3.验证结果并返回
        return rows;
    }


}
