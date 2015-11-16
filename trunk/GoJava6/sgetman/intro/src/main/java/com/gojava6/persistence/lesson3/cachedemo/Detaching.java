/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.persistence.lesson3.cachedemo;

import com.gojava6.persistence.lesson3.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/16/15
 */
public class Detaching {
    public static void main(String[] args) {
        //intialize EMF
        EntityManagerFactory
                entityManagerFactory = Persistence.createEntityManagerFactory("cache-unit");

        //first load of object CD - create em, tx
        EntityManager em1 = entityManagerFactory.createEntityManager();
        EntityTransaction firstTx = em1.getTransaction();
        firstTx.begin();
        CD cd = em1.find(CD.class, 1L);
        System.out.println(cd);
        firstTx.commit();
        em1.close();

        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction secondTx = em2.getTransaction();
        secondTx.begin();
        CD cd2 = em2.find(CD.class, 1L);
        cd2.setTitle("Detach");
        em2.detach(cd2);
        System.out.println(cd2);
        secondTx.commit();
        System.out.println(cd2);

        EntityTransaction thirdTx = em2.getTransaction();
        thirdTx.begin();
        CD cd3 = em2.find(CD.class, 1L);
        //cd3.setTitle("Detach");
        System.out.println(cd3);
        thirdTx.commit();
        em2.close();
        entityManagerFactory.close();
    }
}
