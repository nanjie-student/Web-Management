package com.cy.pj.category.dao;

import com.cy.pj.category.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryDao {//$Proxy35

      @Select("select * from tb_category")
      List<Category> findCategorys();
}
