package ua.com.goit.gojava7.kickstarter.model.storage;

import org.hibernate.Session;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;

import java.util.List;

public class DatabaseQuoteStorage2 implements QuoteStorage {
    @Override
    public List<Quote> getQuotes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        Quote quote = session.get(Quote.class, 1);
//        List<Quote> quotes = Arrays.asList(quote);
        List<Quote> quotes = session.createCriteria(Quote.class).list();
//        List<Quote> quotes = session.createQuery("from Quote").list();
//        System.out.println(quotes);

        session.getTransaction().commit();
        session.close();

        return quotes;
    }

    @Override
    public void add(Quote quote) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(quote);

        session.getTransaction().commit();
        session.close();
    }

}
