/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.persistence.lesson3.cachedemo;

import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/15/15
 */
public class QueryLevelCacheDemo {
    public static void main(String[] args) {
        //intialize EMF
        EntityManagerFactory
                entityManagerFactory = Persistence.createEntityManagerFactory("cache-unit");

        EntityManager em = entityManagerFactory.createEntityManager();
        //Create named query
        Query query = em.createNamedQuery("select.title");
        query.setParameter("title", "Cache");
        query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.USE);
        System.out.println(query.getSingleResult());




        System.out.println(query.getSingleResult());

        em.close();
        entityManagerFactory.close();

    }
}
