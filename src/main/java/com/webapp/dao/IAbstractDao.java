package com.webapp.dao;

import java.util.List;

public interface IAbstractDao<T> {
     void create(T entity);
     void update(T entity);
     void delete(T entity);
     T getByKey(long id);
     List<T> getAll();
     void deleteByKey(long id);

}
