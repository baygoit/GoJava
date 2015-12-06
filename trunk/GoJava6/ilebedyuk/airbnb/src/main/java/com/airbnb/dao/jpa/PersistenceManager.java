package com.airbnb.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Игорь on 14.11.2015.
 */
public class PersistenceManager {
//    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("airbnb");
//
//    public EntityManagerFactory getEmf() {
//        return emf;
//    }

    private static final PersistenceManager singleton = new PersistenceManager();

    protected EntityManagerFactory emf;

    public static PersistenceManager getInstance() {
        return singleton;
    }

    private PersistenceManager() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null)
            createEntityManagerFactory();
        return emf;
    }

    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    protected void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("airbnb");
    }
}
