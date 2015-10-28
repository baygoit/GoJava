package ua.com.goit.gojava.kickstarter.dao;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava.kickstarter.data.Quote;
import ua.com.goit.gojava.kickstarter.data.Quotes;

@Repository
public class QuoteDao extends AbstractDao implements Quotes {

	
	@Override
	public Quote getRandomQuote() {
		Random rand = new Random();
		int id = rand.nextInt(size())+1;
		Session session = getCurrentSession();
		return (Quote) session.get(Quote.class, id);
	}

	@Override
	public int size() {
		Session session = getCurrentSession();
		Number n = (Number) session.createCriteria(Quote.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return n.intValue();
	}
	
}
