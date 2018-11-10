package com.webapp.controller;



import com.webapp.model.CartNewItemDTO;
import com.webapp.model.entity.Cart;
import com.webapp.model.entity.OrderLine;
import com.webapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
public class CartController {


    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService=cartService;
    }

    @RequestMapping("/cart")
    public String getCartPage(){
        return "cart/cart";
    }

    @RequestMapping("/cart/check")
    public @ResponseBody
    Cart checkCart(Principal principal){
        return cartService.checkIfExistAddIfNot(principal.getName());
    }

    @RequestMapping("/cart/getlines/{cartId}")
    public @ResponseBody
    List<OrderLine> getLinesByCartId(@PathVariable("cartId") long cartId){
        return cartService.getOrderLinesByCartId(cartId);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrderLine(@RequestParam("id") long id){
        cartService.deleteOrderLineById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/additem",method = RequestMethod.POST)
    public @ResponseBody
    OrderLine addProductToCart(@RequestBody CartNewItemDTO newItem, Principal principal,
                               HttpServletResponse response){
        OrderLine returned = cartService.addItemToCart(newItem, principal.getName());
        if(returned==null)
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        return returned;
    }

    @RequestMapping(value = "/updateitem", method = RequestMethod.PUT)
    public @ResponseBody
    OrderLine updateOrderLine(@RequestBody OrderLine orderLine, HttpServletResponse response){
        OrderLine returned = cartService.updateOrderLine(orderLine);
        if(returned==null)
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        return returned;
    }




}
