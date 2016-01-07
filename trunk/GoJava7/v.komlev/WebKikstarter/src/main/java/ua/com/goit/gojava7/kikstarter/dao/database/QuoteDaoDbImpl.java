package ua.com.goit.gojava7.kikstarter.dao.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

@Repository
public class QuoteDaoDbImpl implements QuoteDao {

	private static final String SELECT_RANDOM_QUOTE = "SELECT * FROM (SELECT * FROM quotes ORDER BY DBMS_RANDOM.VALUE) WHERE rownum = 1";
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Quote quote) {

	}

	@Override
	public void remove(Quote quote) {

	}

	@Override
	public Quote getRandomQuote() {
		Session session = sessionFactory.openSession();
		
		Quote quote = (Quote) session.createCriteria(Quote.class)
				.add(Restrictions.sqlRestriction(SELECT_RANDOM_QUOTE))
				.setMaxResults(1)
				.uniqueResult();
		
		session.close();
		
		return quote;
	}
}
