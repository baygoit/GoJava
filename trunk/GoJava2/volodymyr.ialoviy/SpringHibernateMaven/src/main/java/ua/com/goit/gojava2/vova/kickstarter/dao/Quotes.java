package ua.com.goit.gojava2.vova.kickstarter.dao;

import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava2.vova.kickstarter.model.Quote;

@Repository("quoteDao")
public class Quotes extends AbstractDao implements QuoteDao{

	@Override
	public Quote getQuote() {
		long count = getCount();
		int id = getRandom(count);
        return (Quote) getSession().get(Quote.class, id);
	}

	private long getCount() {
		return (long) getSession().createCriteria(Quote.class).setProjection(Projections.rowCount()).uniqueResult();
	}
	
	private int getRandom(long count) {
		return (int) (Math.random() * (count) + 1);
	}
	
}
