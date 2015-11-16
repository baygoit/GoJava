/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.persistence.lesson3.cachedemo;

import com.gojava6.persistence.lesson3.CD;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/15/15
 */
public class SecondLevelCachesChecker {
    public static void main(String[] args) {
        //intialize EMF
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cache-unit");

        //first load of object CD - create em, tx
        EntityManager em1 = entityManagerFactory.createEntityManager();
        EntityTransaction firstTx = em1.getTransaction();
        firstTx.begin();
        System.out.println(em1.find(CD.class, 1L));
        firstTx.commit();
        em1.close();

        //check wheather we have such object in cache
        Cache cache = entityManagerFactory.getCache();

        if(!cache.contains(CD.class, 1L)) {
            throw new RuntimeException("Not cached!");
        }

        //second load should be from cache
        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction secondTx = em2.getTransaction();
        secondTx.begin();
        System.out.println(em2.find(CD.class, 1L));
        secondTx.commit();
        em2.close();

        entityManagerFactory.close();
    }
}
