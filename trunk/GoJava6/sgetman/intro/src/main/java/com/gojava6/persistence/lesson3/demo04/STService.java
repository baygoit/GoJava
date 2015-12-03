/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.persistence.lesson3.demo04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/16/15
 */
public class STService {
    public static void main(String[] args) {
        EntityManagerFactory
                emf = Persistence.createEntityManagerFactory("module01-persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(new Sample());
        tx.commit();
        em.close();
        emf.close();




    }
}
