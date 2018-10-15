package com.webapp.dao;

import com.webapp.model.entity.Photo;
import com.webapp.model.entity.Product;

import java.util.List;

public interface PhotoDao extends IAbstractDao<Photo> {
    List<Photo> getPhotosByProduct(Product product);
}
