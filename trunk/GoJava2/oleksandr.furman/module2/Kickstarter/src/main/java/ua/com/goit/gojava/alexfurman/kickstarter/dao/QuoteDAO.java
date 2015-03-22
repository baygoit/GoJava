package ua.com.goit.gojava.alexfurman.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Quote;
@Transactional
public class QuoteDAO {

	private SessionFactory sessionFactory;

	public QuoteDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public Quote getQuoteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Quote quote = (Quote) session.load(Quote.class, new Integer(id));
		Hibernate.initialize(quote.getQuote());
		return quote;
	}

	public Number size() {
		Session session = this.sessionFactory.getCurrentSession();
		Number number = (Number) session.createQuery("select count(*) from Quote").uniqueResult();
		return number.intValue();
	}
}
