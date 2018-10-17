package com.webapp.dao;

import com.webapp.model.entity.Customer;

public interface CustomerDao extends IAbstractDao<Customer> {
    Customer getCustomerByUsername(String username);
    Customer addNewCustomer(Customer customer);
    Customer updateCustomer(Customer customer);

}
