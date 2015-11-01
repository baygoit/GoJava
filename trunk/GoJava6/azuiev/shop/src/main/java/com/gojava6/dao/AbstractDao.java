/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.dao;

import com.gojava6.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/28/15
 */
public abstract class AbstractDao<T, S> {

    protected EntityManager entityManager;

    public AbstractDao() {
        entityManager = Persistence.createEntityManagerFactory("AffableBeanPU").createEntityManager();
    }

    public abstract List<T> findAll();

    public abstract T find(S id);
}
