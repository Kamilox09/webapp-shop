package com.webapp.dao;


import com.webapp.model.entity.Category;

public interface CategoryDao extends IAbstractDao<Category> {
    Category getCategoryByName(String name);
}
