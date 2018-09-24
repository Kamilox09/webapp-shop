package com.webapp.dao.impl;


import com.webapp.dao.IAbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T> implements IAbstractDao<T> {
    private final Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.entityClass=(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T create(T entity){
        getSession().save(entity);
        return entity;
    }

    public T update(T entity){
        getSession().update(entity);
        return entity;
    }

    public void delete(T entity){
        getSession().delete(entity);
    }

    public T getByKey(long id){
        return getSession().get(entityClass,id);
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll(){
        return getSession().createQuery("from "+entityClass.getName()).list();
    }

    public void deleteByKey(long id){
        delete(getByKey(id));
    }

}
