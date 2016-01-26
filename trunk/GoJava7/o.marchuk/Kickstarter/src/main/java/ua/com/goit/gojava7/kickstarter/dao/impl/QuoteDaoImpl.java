package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Repository
@Transactional
public class QuoteDaoImpl implements QuoteDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Quote getRandomQuote() {
		Query query = em.createNamedQuery("Quote.count");
		Long count = (Long) query.getSingleResult();

		Random random = new Random();
		int number = random.nextInt(count.intValue());

		Query selectQuery = em.createNamedQuery("Quote.findAll");
		selectQuery.setFirstResult(number);
		selectQuery.setMaxResults(1);

		Quote quote = (Quote) selectQuery.getSingleResult();

		return quote;
	}

}
