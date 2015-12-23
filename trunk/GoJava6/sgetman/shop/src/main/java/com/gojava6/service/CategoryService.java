/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.service;

import com.gojava6.dao.CategoryDao;
import com.gojava6.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.SQLDataException;
import java.util.List;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Transactional(readOnly = true)
    public Category find(short i) {
        return categoryDao.find(i);
    }

    @Transactional
    public Category create(Category category) {
        return categoryDao.create(category);
    }

    @Transactional
    public Category update(short categoryId, Category category) {
        return categoryDao.update(categoryId, category);
    }

    @Transactional
    public void delete(short categoryId) throws SQLDataException {
        Category category = categoryDao.find(categoryId);
        if (category == null) {
            throw new SQLDataException();
        } else {
            categoryDao.delete(category);
        }
    }
}
