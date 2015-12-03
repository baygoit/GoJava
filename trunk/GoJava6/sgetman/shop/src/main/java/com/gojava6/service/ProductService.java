/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.service;

import com.gojava6.dao.ProductDao;
import com.gojava6.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
@Component
public class ProductService {

    @Autowired
    ProductDao productDao;

    public Product find(int id) {
        return productDao.find(id);
    }

    public Product updatePrice(Integer id, BigDecimal price) {
        return productDao.updatePrice(id, price);
    }
}
