package com.webapp.service.impl;


import com.webapp.dao.CategoryDao;
import com.webapp.model.entity.Category;
import com.webapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }

    @Override
    public Category addCategory(Category category) {
        Category check = categoryDao.getCategoryByName(category.getName());
        if(check!=null)
            return null;
        return categoryDao.create(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryDao.getByKey(id);
    }

    @Override
    public Category updateCategory(Category category) {
        Category check = categoryDao.getCategoryByName(category.getName());
        if(check!=null)
            return null;
        return categoryDao.update(category);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryDao.deleteByKey(id);
    }

    @Override
    public Category getByName(String name) {
        return categoryDao.getCategoryByName(name);
    }
}
