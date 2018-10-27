package com.webapp.dao.impl;

import com.webapp.dao.ProductDao;
import com.webapp.model.entity.Category;
import com.webapp.model.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

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

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProductsForPage(long page, Category category) {
        if(category==null) {
            Query query = getSession().createQuery("from Product where active=true");
            return query
                    .setFirstResult(((int)page-1)*15)
                    .setMaxResults(15)
                    .list();
        }
        Query query = getSession().createQuery("from Product where active=true and category=:category");
        query.setParameter("category",category);
        return query
                .setFirstResult(((int)page-1)*15)
                .setMaxResults(15)
                .list();
    }
}
