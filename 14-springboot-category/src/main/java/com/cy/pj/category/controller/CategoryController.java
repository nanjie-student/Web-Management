package com.cy.pj.category.controller;

import com.cy.pj.category.pojo.Category;
import com.cy.pj.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/doFindCategorys")
    public List<Category> doFindCategorys(){
        return categoryService.findCategorys();
    }
}
