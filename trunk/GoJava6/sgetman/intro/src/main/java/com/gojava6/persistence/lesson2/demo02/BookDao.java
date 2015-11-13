/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.persistence.lesson2.demo02;

import com.gojava6.persistence.lesson2.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/9/15
 */
public class BookDao {
    private EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("module01-persistence-unit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public Book createBook(Book book) {
        tx.begin();
        em.persist(book);
        tx.commit();
        return book;
    }

    public void removeBook(Long id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            tx.begin();
            em.remove(book);
            tx.commit();
        }
    }

    public Book findBook(Long id) {
        return em.find(Book.class, id);
    }

    public Book raiseUnitCost(Long id, Float raise) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            tx.begin();
            book.setUnitCost(book.getUnitCost() + raise);
            tx.commit();
        }
        return book;
    }
}
