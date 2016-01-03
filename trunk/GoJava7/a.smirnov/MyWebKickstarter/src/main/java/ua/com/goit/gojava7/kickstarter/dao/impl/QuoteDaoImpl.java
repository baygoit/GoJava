package ua.com.goit.gojava7.kickstarter.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Quote getRandomQuote() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Quote.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(1);

		Quote quote = (Quote) criteria.uniqueResult();
		return quote;
	}

	@Override
	public void add(Quote quote) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(Quote quote) {
		// TODO Auto-generated method stub
	}
}
