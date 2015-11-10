/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6;

import com.gojava6.entity.Category;
import com.gojava6.entity.Product;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/9/15
 */
public class CascadeTest {
    @Test
    public void testCascadeType() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("AffableBeanPU").createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Category category = new Category();
        category.setName("test_category1");
        Product product = new Product();
        product.setName("test_product2");
        product.setPrice(new BigDecimal(2.70));
        product.setDescription("just for fun");
        product.setLastUpdate(new Date());
        product.setCategory(category);
        category.setProducts(new ArrayList<Product>());
        category.getProducts().add(product);

        transaction.begin();
        entityManager.persist(category);
        transaction.commit();

        transaction.begin();
        entityManager.remove(category);
        transaction.commit();


    }
}
