package com.webapp.dao.impl;

import com.webapp.dao.CategoryDao;
import com.webapp.model.entity.Category;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {
    @Override
    public Category getCategoryByName(String name) {
        Query query = getSession().createQuery("from Category where name =:name");
        query.setParameter("name",name);
        return (Category)query.uniqueResult();
    }
}
