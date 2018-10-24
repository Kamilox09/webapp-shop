package com.webapp.dao;

import com.webapp.model.entity.Category;
import com.webapp.model.entity.Product;

public interface ProductDao extends IAbstractDao<Product> {
    long getCountOfActiveProducts();
    long getCountOfActiveProductsByCategory(Category category);
}
