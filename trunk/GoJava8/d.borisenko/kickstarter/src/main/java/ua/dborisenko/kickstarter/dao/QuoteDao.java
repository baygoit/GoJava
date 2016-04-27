package ua.dborisenko.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Quote;

@Repository
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class QuoteDao {

    private static final String GET_RANDOM_QUOTE_SQL = "SELECT id, author, text FROM quotes ORDER BY rand() limit 1";
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public Quote getRandom() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(GET_RANDOM_QUOTE_SQL).addEntity(Quote.class);
        List<Quote> resultList = query.list();
        Quote quote = resultList.get(0);
        return quote;
    }
}
