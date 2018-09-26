package com.webapp.service;

import com.webapp.model.entity.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(long id);
    Category updateCategory(Category category);
    void deleteCategoryById(long id);
}
