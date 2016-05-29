package ua.dborisenko.kickstarter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Quote;

@Repository
@Transactional
public class QuoteDao {

    @PersistenceContext
    private EntityManager em;

    public Quote getRandom() {
        Query query = em.createNamedQuery("Quote.getRandom", Quote.class);
        return (Quote) query.getSingleResult();
    }
}
