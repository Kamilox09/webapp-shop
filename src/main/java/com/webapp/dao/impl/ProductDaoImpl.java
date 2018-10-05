package com.webapp.dao.impl;

import com.webapp.dao.ProductDao;
import com.webapp.model.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
@Transactional
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
}
