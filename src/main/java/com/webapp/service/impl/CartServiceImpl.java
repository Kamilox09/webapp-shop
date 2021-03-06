package com.webapp.service.impl;

import com.webapp.dao.CartDao;
import com.webapp.dao.OrderLineDao;
import com.webapp.model.CartNewItemDTO;
import com.webapp.model.entity.Cart;
import com.webapp.model.entity.Customer;
import com.webapp.model.entity.OrderLine;
import com.webapp.model.entity.Product;
import com.webapp.service.CartService;
import com.webapp.service.CustomerService;
import com.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    private final CartDao cartDao;
    private final CustomerService customerService;
    private final OrderLineDao orderLineDao;
    private final ProductService productService;

    @Autowired
    public CartServiceImpl(CartDao cartDao,
                           CustomerService customerService,
                           OrderLineDao orderLineDao,
                           ProductService productService){
        this.cartDao=cartDao;
        this.customerService=customerService;
        this.orderLineDao=orderLineDao;
        this.productService=productService;
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

    @Override
    public OrderLine addItemToCart(CartNewItemDTO cartNewItemDTO, String username) {
        Product product = productService.getById(cartNewItemDTO.getProductId());
        if(product.getQuantity()<cartNewItemDTO.getQuantity())
            return null;
        Cart cart = this.checkIfExistAddIfNot(username);
        OrderLine orderLine = orderLineDao.getOrderLineByProductIdAndCartId(cartNewItemDTO.getProductId(),
               cart.getCartId() );
        if(orderLine==null) {
            orderLine = new OrderLine();
            orderLine.setCart(cart);
            orderLine.setProduct(product);
            orderLine.setQuantity((int) cartNewItemDTO.getQuantity());
            orderLine.setGrossPricePerItem(product.getGrossPrice());
            orderLine.setNetPricePerItem(product.getNetPrice());
            orderLine.setVat(product.getVat());
            orderLine = orderLineDao.create(orderLine);
            cart.setTotalPrice(countCartTotalPrice(cart));
            cartDao.update(cart);
        }else{
            if(product.getQuantity()<(orderLine.getQuantity()+(int)cartNewItemDTO.getQuantity()))
                return null;
            orderLine.setQuantity(orderLine.getQuantity()+(int)cartNewItemDTO.getQuantity());
            orderLine = orderLineDao.update(orderLine);
            cart.setTotalPrice(countCartTotalPrice(cart));
            cartDao.update(cart);

        }

        return orderLine;
    }

    @Override
    public double countCartTotalPrice(Cart cart) {
        List<OrderLine> orderLineList = orderLineDao.getOrderLinesByCart(cart);
        double sum = 0.0;
        for (OrderLine orderLine: orderLineList) {
            sum +=(orderLine.getQuantity()*orderLine.getGrossPricePerItem());
        }
        return sum;
    }

    @Override
    public List<OrderLine> getOrderLinesByCartId(long cartId) {
        return orderLineDao.getOrderLinesByCartId(cartId);
    }

    @Override
    public void deleteOrderLineById(long orderLineId) {
        OrderLine orderLine = orderLineDao.getByKey(orderLineId);
        Cart cart = orderLine.getCart();
        orderLineDao.deleteByKey(orderLineId);
        cart.setTotalPrice(countCartTotalPrice(cart));
        cartDao.update(cart);
    }

    @Override
    public OrderLine updateOrderLine(OrderLine orderLine) {
        if(orderLine.getQuantity()>orderLine.getProduct().getQuantity()){
            return null;
        }
        OrderLine updated =orderLineDao.update(orderLine);
        Cart cart = updated.getCart();
        cart.setTotalPrice(countCartTotalPrice(updated.getCart()));
        orderLineDao.flushSession();
        cartDao.flushSession();
        cartDao.clearSession();
        cartDao.update(cart);
        return updated;
    }

    @Override
    public Cart buy(String username) {
        Customer customer = customerService.getCustomerByUsername(username);
        Cart cart = cartDao.checkIfExist(customer);
        List<OrderLine> orderLines = this.getOrderLinesByCartId(cart.getCartId());

        for (OrderLine orderLine : orderLines) {
            productService.sellProducts(orderLine.getProduct().getProductId(),orderLine.getQuantity());
        }

        cart.setPurchaseDate(new Timestamp(System.currentTimeMillis()));
        cart.setDispatchDate(new Timestamp(System.currentTimeMillis()));
        cartDao.update(cart);
        return this.checkIfExistAddIfNot(username);
    }
}
