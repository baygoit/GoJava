package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.models.Quote;

@Repository
public class QuoteDao {

	private static final Logger log = LoggerFactory.getLogger(QuoteDao.class);

	public Quote getRandomQuote() {
		log.info("<Quote> getRandomQuote()...");
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Quote.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(1);

		Quote quote = (Quote) criteria.uniqueResult();

		session.close();
		log.debug("getRandomQuote() returned quote: {}", quote);
		return quote;
	}
}
