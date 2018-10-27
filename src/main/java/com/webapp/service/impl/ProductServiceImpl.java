package com.webapp.service.impl;


import com.webapp.dao.ProductDao;
import com.webapp.model.entity.Product;
import com.webapp.service.CategoryService;
import com.webapp.service.ManufacturerService;
import com.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    private final ManufacturerService manufacturerService;

    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductDao productDao,
                              ManufacturerService manufacturerService,
                              CategoryService categoryService){
        this.productDao=productDao;
        this.manufacturerService=manufacturerService;
        this.categoryService=categoryService;
    }

    @Override
    public Product getById(long id) {
        return productDao.getByKey(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public Product addProduct(Product product) {
        product.setManufacturer(manufacturerService.getByName(product.getManufacturer().getName()));
        product.setCategory(categoryService.getByName(product.getCategory().getName()));
        return productDao.create(product);
    }

    @Override
    public Product editProduct(Product product) {
        product.setManufacturer(manufacturerService.getByName(product.getManufacturer().getName()));
        product.setCategory(categoryService.getByName(product.getCategory().getName()));
        return productDao.update(product);
    }

    @Override
    public long getCountOfActiveProducts() {
        return productDao.getCountOfActiveProducts();
    }

    @Override
    public long getCountOfActiveProductsByCategory(String categoryName) {
        return productDao.getCountOfActiveProductsByCategory(categoryService.getByName(categoryName));
    }

    @Override
    public List<Product> getProductsForPage(long page, String categoryName) {
        return productDao.getProductsForPage(page,categoryService.getByName(categoryName));
    }
}
