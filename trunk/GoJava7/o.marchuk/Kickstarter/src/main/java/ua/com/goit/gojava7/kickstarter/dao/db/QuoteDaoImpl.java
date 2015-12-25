package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@Override
	public Quote getRandomQuote() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Quote.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(1);

		List<Quote> quotes = criteria.list();
		if (quotes.isEmpty()) {
			return null;
		}

		Quote quote = quotes.get(0);

		session.close();

		return quote;
	}

}
