package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
@Repository
public class QuoteDatabaseDao{
    private static final Logger logger = LogManager.getLogger(QuoteDatabaseDao.class);
<<<<<<< HEAD

    public Quote getRandomQuote() {
        logger.debug("Getting random Quote");
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("from Quote q order by rand()");
        List<Quote> quotes = HibernateUtil.listAndCast(query.setMaxResults(1));
        if(quotes.isEmpty()){
        	throw new NoSuchElementException();
=======
    @Autowired
    private SessionFactory      sessionFactory;

    @SuppressWarnings("unchecked")
    public Quote getRandomQuote() {
        logger.debug("Getting random Quote");
        Session session = sessionFactory.openSession();
        List<Quote> quotes = (List<Quote>) session.createQuery("from Quote q order by rand()").setMaxResults(1).list();
        if (quotes.isEmpty()) {
            throw new NoSuchElementException();
>>>>>>> b0014930bf8740a544b0060d43ef290b3bc57753
        }
        Quote q = quotes.get(0);
        session.close();
        return q;
    }

}
