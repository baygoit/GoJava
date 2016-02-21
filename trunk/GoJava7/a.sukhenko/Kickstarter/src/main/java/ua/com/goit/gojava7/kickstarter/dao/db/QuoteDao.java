package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.model.Quote;
@Repository
@Transactional
public class QuoteDao{
    private static final Logger logger = LogManager.getLogger(QuoteDao.class);
    private Random              random = new Random();

    @PersistenceContext
    private EntityManager       manager;

    public Quote getRandomQuote() {
        Query query = manager.createNamedQuery("Quote.count");
        Long count = (Long) query.getSingleResult();

        int number = random.nextInt(count.intValue());

        Query selectQuery = manager.createNamedQuery("Quote.findAll");
        selectQuery.setFirstResult(number);
        selectQuery.setMaxResults(1);

        Quote quote = (Quote) selectQuery.getSingleResult();

        return quote;
    }

}
