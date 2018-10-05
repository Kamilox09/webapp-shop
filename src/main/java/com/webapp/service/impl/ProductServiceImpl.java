package com.webapp.service.impl;


import com.webapp.dao.ProductDao;
import com.webapp.model.entity.Product;
import com.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao){
        this.productDao=productDao;
    }

    @Override
    public Product getById(long id) {
        Product product = productDao.getByKey(id);
        product.getCategory();
        product.getManufacturer();
        return product;
    }
}
