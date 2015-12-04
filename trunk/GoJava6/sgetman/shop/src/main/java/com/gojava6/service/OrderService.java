/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.service;

import com.gojava6.cart.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
@Component
public class OrderService {
    public int placeOrder(String name, String email, String phone, String address, String cityRegion, String ccNumber, ShoppingCart cart) {
        return 0;
    }

    public Map getOrderDetails(int orderId) {
        return null;
    }
}
