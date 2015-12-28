package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
@Repository
public class QuoteDatabaseDao{
    private static final Logger logger = LogManager.getLogger(QuoteDatabaseDao.class);



    @SuppressWarnings("unchecked")
    public Quote getRandomQuote() {
        logger.debug("Getting random Quote");
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Quote> quotes = (List<Quote>) session.createQuery("from Quote q order by rand()").setMaxResults(1).list();
        if(quotes.isEmpty()){
        	throw new NoSuchElementException();
        }
        Quote q = quotes.get(0);
        session.close();
        return q;
    }  

}
