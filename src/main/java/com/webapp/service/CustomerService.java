package com.webapp.service;

import com.webapp.model.entity.Customer;

public interface CustomerService {
    Customer getCustomerByUsername(String username);
}
