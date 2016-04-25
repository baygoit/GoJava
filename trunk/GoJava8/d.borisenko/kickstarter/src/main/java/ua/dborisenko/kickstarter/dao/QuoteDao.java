package ua.dborisenko.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Quote;

@Repository
public class QuoteDao {

    private static final String GET_RANDOM_QUOTE_SQL = "SELECT id, author, text FROM quotes ORDER BY rand() limit 1";
    @Autowired
    private SessionFactory sessionFactory;

    public Quote getRandom() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery(GET_RANDOM_QUOTE_SQL).addEntity(Quote.class);
        List<Quote> resultList = query.list();
        Quote quote = resultList.get(0);
        tx.commit();
        session.close();
        return quote;
    }
}
