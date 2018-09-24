package com.webapp.service;

import com.webapp.model.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    Manufacturer addManufacturer(Manufacturer manufacturer);
    List<Manufacturer> getAllManufacturers();
    Manufacturer getManufacturerById(Long id);
    Manufacturer updateManufacturer(Manufacturer manufacturer);
    void deleteManufacturerById(long id);
}
