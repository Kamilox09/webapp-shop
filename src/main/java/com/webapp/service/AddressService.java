package com.webapp.service;

import com.webapp.model.entity.Address;
import com.webapp.model.entity.Customer;

public interface AddressService {
    Address addNewAddress(Address address);
    Address getCurrentAddressByCustomer(Customer customer);
    Address updateAddress(Address address);
}
