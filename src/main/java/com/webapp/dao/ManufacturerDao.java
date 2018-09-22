package com.webapp.dao;

import com.webapp.model.entity.Manufacturer;

public interface ManufacturerDao extends IAbstractDao<Manufacturer> {
    Manufacturer getManufacturerByName(String name);
}
