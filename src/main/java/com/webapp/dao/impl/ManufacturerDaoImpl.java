package com.webapp.dao.impl;

import com.webapp.dao.ManufacturerDao;
import com.webapp.model.entity.Manufacturer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("manufacturerDao")
@Transactional
public class ManufacturerDaoImpl extends AbstractDao<Manufacturer> implements ManufacturerDao {
    @Override
    public Manufacturer getManufacturerByName(String name) {
        Query query = getSession().createQuery("from Manufacturer where name =:name");
        query.setParameter("name",name);
        return (Manufacturer)query.uniqueResult();
    }
}
