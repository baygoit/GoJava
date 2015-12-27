package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.models.Quote;

@Repository
public class QuoteDao {
	
	private static final Logger log = LoggerFactory.getLogger(QuoteDao.class);
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public Quote getRandomQuote() {
		log.info("<Quote> getRandomQuote()...");
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Quote> quotes = (List<Quote>) session.createQuery("from Quote q order by rand()").setMaxResults(1).list();
        if(quotes.isEmpty()){
        	throw new NoSuchElementException();
        }
        Quote quote = quotes.get(0);
        session.close();
        return quote;
    }  
}
