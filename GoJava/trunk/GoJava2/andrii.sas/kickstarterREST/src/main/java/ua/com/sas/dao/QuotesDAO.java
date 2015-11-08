package ua.com.sas.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.com.sas.model.Quote;

@Repository
public class QuotesDAO extends AbstractDAO implements Quotes {

	@Override
	public Quote get(int id) {
		Session session = getSession();
		return (Quote) session.get(Quote.class, id);
	}

	@Override
	public void add(Quote quote) {
		Session session = getSession();
		session.save(quote);
	}

	@Override
	public int size() {
		return ( (Long) getSession().createQuery("SELECT count(o) FROM Quote o").iterate().next() ).intValue();
	}

}
