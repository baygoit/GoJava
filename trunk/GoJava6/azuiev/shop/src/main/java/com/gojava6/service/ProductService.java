/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.service;

import com.gojava6.dao.ProductDao;
import com.gojava6.entity.Product;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
public class ProductService {

    ProductDao productDao = new ProductDao();

    public Product find(int id) {
        return productDao.find(id);
    }
}
