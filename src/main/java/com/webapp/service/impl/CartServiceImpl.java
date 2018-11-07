package com.webapp.service.impl;

import com.webapp.dao.CartDao;
import com.webapp.model.entity.Cart;
import com.webapp.model.entity.Customer;
import com.webapp.model.entity.OrderLine;
import com.webapp.service.CartService;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    private final CartDao cartDao;
    private final CustomerService customerService;

    @Autowired
    public CartServiceImpl(CartDao cartDao, CustomerService customerService){
        this.cartDao=cartDao;
        this.customerService=customerService;
    }

    @Override
    public Cart checkIfExistAddIfNot(String username) {
        Customer customer = customerService.getCustomerByUsername(username);
        Cart check = cartDao.checkIfExist(customer);
        if(check==null){
            Cart cart = new Cart();
            cart.setCustomer(customer);
            cart.setPaid(false);
            cart.setTotalPrice(0);
            cart.setDispatchDate(null);
            cart.setPurchaseDate(null);
            cart.setOrderLineList(Collections.emptyList());
            return cartDao.create(cart);
        }
        return check;
    }
}
