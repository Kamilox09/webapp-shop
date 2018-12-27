package com.webapp.service;

import com.webapp.model.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product getById(long id);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product editProduct(Product product);
    long getCountOfActiveProducts();
    long getCountOfActiveProductsByCategory(String categoryName);
    List<Product> getProductsForPage(long page, String categoryName);
    void sellProducts(long id, int soldAmount);
}
