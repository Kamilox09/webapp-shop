package com.webapp.dao;

import com.webapp.model.entity.Manufacturer;

public interface ManufacturerDao {
    Manufacturer getManufacturerByName(String name);
}
