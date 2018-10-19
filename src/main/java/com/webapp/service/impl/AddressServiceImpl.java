package com.webapp.service.impl;

import com.webapp.dao.AddressDao;
import com.webapp.model.entity.Address;
import com.webapp.model.entity.Customer;
import com.webapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao){
        this.addressDao=addressDao;
    }

    @Override
    public Address addNewAddress(Address address) {
        return addressDao.addNewAddress(address);

    }

    @Override
    public Address getCurrentAddressByCustomer(Customer customer) {
        return addressDao.getCurrentAddressByCustomer(customer);
    }

    @Override
    public Address updateAddress(Address address) {
        Address old = getCurrentAddressByCustomer(address.getCustomer());
        Timestamp newDate = new Timestamp(System.currentTimeMillis());
        old.setToDate(newDate);
        old=addressDao.update(old);
        address.setFromDate(newDate);
        return addressDao.addNewAddress(address);
    }
}
