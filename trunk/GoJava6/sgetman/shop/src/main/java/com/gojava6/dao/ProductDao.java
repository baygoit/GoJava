/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.dao;

import com.gojava6.entity.Category;
import com.gojava6.entity.Product;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
public class ProductDao extends AbstractDao<Product, Integer> {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product find(Integer id) {
        TypedQuery<Product> query =
                entityManager.createNamedQuery("Product.findById", Product.class);
        query.setParameter("id", id);

        return (Product) query.getSingleResult();

    }

    public Product updatePrice(Integer id, BigDecimal price) {
        EntityTransaction tx = entityManager.getTransaction();
        Product product = find(id);

        tx.begin();
        product.setPrice(price);
        tx.commit();

        return product;
    }
}
