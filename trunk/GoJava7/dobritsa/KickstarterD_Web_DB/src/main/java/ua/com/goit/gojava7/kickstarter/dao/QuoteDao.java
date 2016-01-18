package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.models.Quote;

@Repository
@Transactional
public class QuoteDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(QuoteDao.class);

	public Quote getRandomQuote() {
		log.info("<Quote> getRandomQuote()...");
		Session session = sessionFactory.getCurrentSession();

		return (Quote) session.createCriteria(Quote.class)
				.add(Restrictions.sqlRestriction("1=1 order by rand()"))
				.setMaxResults(1)
				.uniqueResult();
	}
}
