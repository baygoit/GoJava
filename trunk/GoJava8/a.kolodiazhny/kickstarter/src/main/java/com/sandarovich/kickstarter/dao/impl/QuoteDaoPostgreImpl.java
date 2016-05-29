package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.QuoteDao;
import com.sandarovich.kickstarter.model.Quote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class QuoteDaoPostgreImpl implements QuoteDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public Quote getRandomQuota() {
        Query query = em.createNamedQuery("Quote.getRandom", Quote.class);
        query.setMaxResults(1);
        return (Quote) query.getSingleResult();
    }
}

