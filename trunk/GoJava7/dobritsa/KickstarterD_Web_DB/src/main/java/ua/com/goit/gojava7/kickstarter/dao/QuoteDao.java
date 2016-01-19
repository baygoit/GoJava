package ua.com.goit.gojava7.kickstarter.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Random;

@Repository
@Transactional
public class QuoteDao {

	private static final Logger log = LoggerFactory.getLogger(QuoteDao.class);

	@PersistenceContext
	private EntityManager em;

	//TODO change random
	public Quote getRandomQuote() {
		log.info("<Quote> getRandomQuote()...");
		Query query = em.createNamedQuery("Quote.count");
		Long count = (Long) query.getSingleResult();

		Random random = new Random();
		int number = random.nextInt(count.intValue());

		Query selectQuery = em.createNamedQuery("Quote.findAll");
		selectQuery.setFirstResult(number);
		selectQuery.setMaxResults(1);

		Quote quote = (Quote) selectQuery.getSingleResult();

		log.info("<Quote> getRandomQuote() returned {}", quote);
		return quote;
	}
}
