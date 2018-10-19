package com.webapp.dao;

import com.webapp.model.entity.Address;
import com.webapp.model.entity.Customer;

public interface AddressDao {
    Address addNewAddress(Address address);
    Address getCurrentAddressByCustomer(Customer customer);
}
