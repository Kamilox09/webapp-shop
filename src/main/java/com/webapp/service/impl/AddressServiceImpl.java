package com.webapp.service.impl;

import com.webapp.dao.AddressDao;
import com.webapp.model.entity.Address;
import com.webapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public Address addNewAddress(Address address) {
        return addressDao.addNewAddress(address);

    }
}