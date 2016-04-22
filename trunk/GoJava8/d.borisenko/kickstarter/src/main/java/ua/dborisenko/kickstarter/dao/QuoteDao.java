package ua.dborisenko.kickstarter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Quote;

@Repository
public class QuoteDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Quote quote) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(quote);
        tx.commit();
    }

    public Quote getRandom() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.getNamedQuery("getRandomQuote");
        Quote quote = (Quote) query.list().get(0);
        tx.commit();
        return quote;
    }
}
