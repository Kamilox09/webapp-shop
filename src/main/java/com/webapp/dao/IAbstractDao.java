package com.webapp.dao;

import java.util.List;

public interface IAbstractDao<T> {
     T create(T entity);
     T update(T entity);
     void delete(T entity);
     T getByKey(long id);
     List<T> getAll();
     void deleteByKey(long id);

}
