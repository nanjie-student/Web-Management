package com.cy.pj.brand.dao;

import com.cy.pj.brand.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BrandDao {
    /**基于id查询品牌信息*/
    @Select("select * from tb_brand where id=#{id}")
    Brand findById(Integer id);

    @Update("update tb_brand set name=#{name},remark=#{remark} where id=#{id}")
    int updateBrand(Brand brand);

    int insertBrand(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    int deleteById(Integer id);

    //复杂sql(例如嵌套了很多动态sql元素)不建议已注解方式进行定义
    //@Select("<script>select * from tb_brand <if test=\"name!=null and name!=''\"> where name like concat (\"%\",#{name},\"%\")</if></script>")
    List<Brand> findBrands(String name);
}
