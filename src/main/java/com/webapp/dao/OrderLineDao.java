package com.webapp.dao;

import com.webapp.model.entity.Cart;
import com.webapp.model.entity.OrderLine;

import java.util.List;

public interface OrderLineDao extends IAbstractDao<OrderLine> {
    List<OrderLine> getOrderLinesByCart(Cart cart);
    List<OrderLine> getOrderLinesByCartId(long cartId);
    OrderLine getOrderLineByProductIdAndCartId(long productId, long cartId);
}
