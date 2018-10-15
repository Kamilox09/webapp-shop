package com.webapp.dao.impl;

import com.webapp.dao.PhotoDao;
import com.webapp.model.entity.Photo;
import com.webapp.model.entity.Product;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("photoDao")
@Transactional
public class PhotoDaoImpl extends AbstractDao<Photo> implements PhotoDao {

    @Override
    public List<Photo> getPhotosByProduct(Product product) {
        Query query = getSession().createQuery("from Photo where product =:product");
        query.setParameter("product",product);
        return query.list();
    }
}
