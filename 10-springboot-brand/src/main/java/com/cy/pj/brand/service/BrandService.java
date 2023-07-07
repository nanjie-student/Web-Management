package com.cy.pj.brand.service;

import com.cy.pj.brand.pojo.Brand;

import java.util.List;

public interface BrandService {

     Brand findById(Integer id);
     int updateBrand(Brand brand);

     int saveBrand(Brand brand);

     int deleteById(Integer id);

     List<Brand> findBrands(String name);
}
