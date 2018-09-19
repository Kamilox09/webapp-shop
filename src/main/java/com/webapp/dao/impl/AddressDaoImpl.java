package com.webapp.dao.impl;


import com.webapp.dao.AddressDao;
import com.webapp.model.entity.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Address> implements AddressDao {
    @Override
    public Address addNewAddress(Address address) {
        create(address);
        return address;
    }
}
