package com.webapp.service;

import com.webapp.model.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    Manufacturer addManufacturer(Manufacturer manufacturer);
    List<Manufacturer> getAllManufacturers();
    Manufacturer getManufacturerById(long id);
    Manufacturer updateManufacturer(Manufacturer manufacturer);
    void deleteManufacturerById(long id);
    Manufacturer getByName(String name);
}
