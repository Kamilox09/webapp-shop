package com.webapp.dao.impl;

import com.webapp.dao.OrderLineDao;
import com.webapp.model.entity.Cart;
import com.webapp.model.entity.OrderLine;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository("orderLineDao")
public class OrderLineDaoImpl extends AbstractDao<OrderLine> implements OrderLineDao {

    @Override
    public List<OrderLine> getOrderLinesByCart(Cart cart) {
        Query query = getSession().createQuery("from OrderLine where cart=:cart");
        query.setParameter("cart",cart);
        return query.list();
    }

    @Override
    public List<OrderLine> getOrderLinesByCartId(long cartId) {
        Query query = getSession().createQuery("from OrderLine where cart.cartId=:cartId");
        query.setParameter("cartId",cartId);
        return query.list();
    }
}
