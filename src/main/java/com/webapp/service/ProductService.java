package com.webapp.service;

import com.webapp.model.entity.Product;

import java.util.List;

public interface ProductService {
    Product getById(long id);
    List<Product> getAllProducts();
}
