package com.webapp.service;

import com.webapp.model.CartNewItemDTO;
import com.webapp.model.entity.Cart;
import com.webapp.model.entity.OrderLine;

import java.util.List;

public interface CartService {
    Cart checkIfExistAddIfNot(String username);
    OrderLine addItemToCart(CartNewItemDTO cartNewItemDTO, String username);
    double countCartTotalPrice(Cart cart);
    List<OrderLine> getOrderLinesByCartId(long cartId);
    void deleteOrderLineById(long orderLineId);
    OrderLine updateOrderLine(OrderLine orderLine);
    Cart buy(String username);
}
