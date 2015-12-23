/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.dao;

import com.gojava6.entity.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
@Component
public class CategoryDao <T, S>{

    @PersistenceContext
    protected EntityManager entityManager;

    public List<Category> findAll() {
        TypedQuery<Category> query =
                entityManager.createNamedQuery("Category.findAll", Category.class);

        return (List<Category>) query.getResultList();
    }

    public Category find(Short id) {
        return entityManager.find(Category.class, id);
    }

    public Category create(Category category) {
        return entityManager.merge(category);
    }

    public Category update(short categoryId, Category category) {
        Category savedCategory = entityManager.find(Category.class, categoryId);
        savedCategory.setName(category.getName());
        return savedCategory;
    }

    public void delete(T t) {
        entityManager.remove(t);
    }

}
