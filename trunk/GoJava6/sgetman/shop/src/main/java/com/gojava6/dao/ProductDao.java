/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.dao;

import com.gojava6.entity.Category;
import com.gojava6.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
@Component
public class ProductDao extends AbstractDao<Product, Integer> {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product find(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    public Product updatePrice(Integer id, BigDecimal price) {

        Product product = find(id);
        product.setPrice(price);

        return product;
    }
}
