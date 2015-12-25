package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@Override
	public Quote getRandomQuote() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Quote> quotes = (List<Quote>) session.createQuery("from Quote q order by rand()").setMaxResults(1).list();
		if (quotes.isEmpty()) {
			return null;
		}

		Quote quote = quotes.get(0);

		session.close();

		return quote;
	}

}
