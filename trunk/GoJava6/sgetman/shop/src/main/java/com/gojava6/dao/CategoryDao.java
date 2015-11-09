/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.dao;

import com.gojava6.entity.Category;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
public class CategoryDao extends AbstractDao<Category, Short>{

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query =
                entityManager.createNamedQuery("Category.findAll", Category.class);

        return (List<Category>) query.getResultList();
    }

    @Override
    public Category find(Short id) {
        TypedQuery<Category> query =
                entityManager.createNamedQuery("Category.findById", Category.class);
        query.setParameter("id", id);

        /*return (Category) query.getSingleResult();*/
        entityManager.clear();
        return entityManager.find(Category.class, id);
    }
}
