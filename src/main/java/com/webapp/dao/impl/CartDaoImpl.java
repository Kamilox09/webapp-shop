package com.webapp.dao.impl;

import com.webapp.dao.CartDao;
import com.webapp.model.entity.Cart;
import com.webapp.model.entity.Customer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository("cartDao")
public class CartDaoImpl extends AbstractDao<Cart> implements CartDao  {
    @Override
    public Cart checkIfExist(Customer customer) {
        Query query = getSession().createQuery("from Cart where Customer =:customer and purchaseDate is null");
        query.setParameter("customer",customer);
        return (Cart)query.uniqueResult();
    }
}
