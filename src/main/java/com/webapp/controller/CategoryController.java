package com.webapp.controller;

import com.webapp.model.entity.Category;
import com.webapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {


    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @RequestMapping("/category")
    public String getCategoryPage(){
        return "admin/category/category";
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public @ResponseBody
    Category
    addCategory(@RequestBody Category category, HttpServletResponse response){
        Category returned = categoryService.addCategory(category);
        if(returned==null)
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        return returned;
    }

    @RequestMapping(value = "/category/all",method = RequestMethod.GET)
    public @ResponseBody
    List<Category>
    getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
    public String getEditPage(@PathVariable("id") Long categoryId){
        return "admin/category/edit";
    }

    @RequestMapping(value = "/category/get/{id}",method = RequestMethod.GET)
    public @ResponseBody Category
    getCategoryById(@PathVariable("id") Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @RequestMapping(value="/category",method = RequestMethod.PUT)
    public @ResponseBody Category
    updateCategory(@RequestBody Category category, HttpServletResponse response){
        Category returned = categoryService.updateCategory(category);
        if(returned==null)
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        return returned;
    }

    @RequestMapping(value = "/category", method = RequestMethod.DELETE)
    public ResponseEntity deleteCategory(@RequestParam("id") long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
