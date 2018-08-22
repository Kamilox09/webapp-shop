package com.webapp.dao;

import com.webapp.model.entity.Customer;

public interface CustomerDao {
    Customer getCustomerByUsername(String username);
}
