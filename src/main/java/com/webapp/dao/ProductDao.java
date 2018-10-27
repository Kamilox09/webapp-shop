package com.webapp.dao;

import com.webapp.model.entity.Category;
import com.webapp.model.entity.Product;

import java.util.List;

public interface ProductDao extends IAbstractDao<Product> {
    long getCountOfActiveProducts();
    long getCountOfActiveProductsByCategory(Category category);
    List<Product> getProductsForPage(long page,Category category);
}
