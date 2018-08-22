package com.webapp.service.impl;

import com.webapp.dao.CustomerDao;
import com.webapp.model.entity.Customer;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }
}
