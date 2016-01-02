package ua.com.goit.gojava7.kickstarter.dao;

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

		Quote quote = (Quote) session.createCriteria(Quote.class)
				.add(Restrictions.sqlRestriction("1=1 order by rand()"))
				.setMaxResults(1)
				.uniqueResult();

		session.close();
		log.debug("<Quote> getRandomQuote() returned quote: {}", quote);
		return quote;
	}
}
