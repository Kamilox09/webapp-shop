package com.webapp.service.impl;

import com.webapp.dao.CustomerDao;
import com.webapp.model.CustomerAddressDTO;
import com.webapp.model.entity.Address;
import com.webapp.model.entity.Customer;
import com.webapp.service.AddressService;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    private final AddressService addressService;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, AddressService addressService){
        this.customerDao=customerDao;
        this.addressService=addressService;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Customer customer = customerDao.getCustomerByUsername(username);
        if(customer==null)
            throw new RuntimeException("Not found");
        return customer;
    }

    @Override
    public CustomerAddressDTO addNewCustomer( CustomerAddressDTO customerToAdd) {
        Customer customer = customerDao.getCustomerByUsername(customerToAdd.getLogin());
        if(customer!=null)
            return null;
        customer=customerToAdd.getCustomerWithAddress();
        Address address = customerToAdd.getAddress();
        customer=customerDao.addNewCustomer(customer);
        address.setCustomer(customer);
        address=addressService.addNewAddress(address);

        return new CustomerAddressDTO(customer,address);

    }

    @Override
    public Customer editCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }
}
