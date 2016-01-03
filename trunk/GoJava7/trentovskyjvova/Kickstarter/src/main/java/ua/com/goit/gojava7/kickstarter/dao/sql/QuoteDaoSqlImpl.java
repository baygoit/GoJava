package ua.com.goit.gojava7.kickstarter.dao.sql;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Repository
public class QuoteDaoSqlImpl implements QuoteDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Quote getRandomQuote() {

		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Quote.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by random()"));
		criteria.setMaxResults(1);

		Quote quote = (Quote) criteria.uniqueResult();

		return quote;
	}

}
