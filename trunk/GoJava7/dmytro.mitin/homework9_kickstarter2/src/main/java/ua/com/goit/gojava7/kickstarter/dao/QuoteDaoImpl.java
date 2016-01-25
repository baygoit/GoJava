package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;

import java.util.List;

public class QuoteDaoImpl implements QuoteDao {
    @Override
    public List<Quote> getQuotes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Quote> quotes = session.createCriteria(Quote.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//        List<Quote> quotes = session.createQuery("from Quote").list();

        transaction.commit();
        session.close();

        return quotes;
    }

    @Override
    public void add(Quote quote) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(quote);

        transaction.commit();
        session.close();
    }

}
