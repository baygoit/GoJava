package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.QuoteDao;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.Quote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Repository
public class QuoteDaoPostgreImpl implements QuoteDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Override
    public Quote getRandomQuota() {

        try (Session session = sessionFactory.openSession()) {
            int quoteCount = ((Long) session.createCriteria(Quote.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
            if (quoteCount < 1) {
                throw new NoResultException("Quote table is empty");
            }
            int randomQuoteIndex = new Random().nextInt(quoteCount) + 1;
            return session.get(Quote.class, randomQuoteIndex);
        }
    }
}

