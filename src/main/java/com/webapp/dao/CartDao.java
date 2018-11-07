package com.webapp.dao;

import com.webapp.model.entity.Cart;
import com.webapp.model.entity.Customer;

public interface CartDao extends IAbstractDao<Cart> {
    Cart checkIfExist(Customer customer);
}
