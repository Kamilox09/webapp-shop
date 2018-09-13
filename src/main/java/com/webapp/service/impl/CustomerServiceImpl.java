package com.webapp.service.impl;

import com.webapp.dao.CustomerDao;
import com.webapp.model.entity.Customer;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer getCustomerByUsername(String username) {
        Customer customer = customerDao.getCustomerByUsername(username);
        if(customer==null)
            throw new RuntimeException("Not found");
        return customer;
    }
}
