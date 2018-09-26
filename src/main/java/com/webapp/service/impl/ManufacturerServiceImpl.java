package com.webapp.service.impl;

import com.webapp.dao.ManufacturerDao;
import com.webapp.model.entity.Manufacturer;
import com.webapp.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("manufacturerService")
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        Manufacturer check = manufacturerDao.getManufacturerByName(manufacturer.getName());
        if(check!=null)
            return null;
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer getManufacturerById(long id) {
        return manufacturerDao.getByKey(id);
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        Manufacturer check = manufacturerDao.getManufacturerByName(manufacturer.getName());
        if(check!=null)
            return null;
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public void deleteManufacturerById(long id) {
        manufacturerDao.deleteByKey(id);
    }
}
