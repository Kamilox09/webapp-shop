package com.webapp.dao.impl;

import com.webapp.dao.ProductDao;
import com.webapp.model.entity.Category;
import com.webapp.model.entity.Product;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
@Transactional
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
    @Override
    public long getCountOfActiveProducts() {
        Query query = getSession().createQuery("select count(productId) from Product where active=true");
        return (long)query.uniqueResult();
    }

    @Override
    public long getCountOfActiveProductsByCategory(Category category) {
        Query query=getSession().createQuery("select count(productId) from Product where active=true and category=:category");
        query.setParameter("category",category);
        return (long)query.uniqueResult();
    }
}
