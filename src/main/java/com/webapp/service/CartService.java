package com.webapp.service;

import com.webapp.model.entity.Cart;

public interface CartService {
    Cart checkIfExistAddIfNot(String username);
}
