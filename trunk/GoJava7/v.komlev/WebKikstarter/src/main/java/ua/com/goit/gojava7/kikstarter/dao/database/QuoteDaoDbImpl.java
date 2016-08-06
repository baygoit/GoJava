package ua.com.goit.gojava7.kikstarter.dao.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

@Repository
public class QuoteDaoDbImpl implements QuoteDao {
	
	private static final Logger log = Logger.getLogger(QuoteDaoDbImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Quote quote) {

	}

	@Override
	public void remove(Quote quote) {

	}
	
	@Transactional
	@Override
	public Quote getRandomQuote() {
		log.info("start method getRandomQuote()");
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Quote.class);
		criteria.add(Restrictions.sqlRestriction("{alias}.id = (select id from (select id from quotes order by dbms_random.value) where rownum = 1)"));
		criteria.setMaxResults(1);
		
		Quote quote = (Quote) criteria.uniqueResult();
		log.info("Random Quote ID = "+ quote.getId());
		
		return quote;
	}
}
