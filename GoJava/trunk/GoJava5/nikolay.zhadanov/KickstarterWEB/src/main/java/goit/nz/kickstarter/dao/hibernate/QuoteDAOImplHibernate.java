package goit.nz.kickstarter.dao.hibernate;

import goit.nz.kickstarter.dao.AbstractHibernateDAO;
import goit.nz.kickstarter.dao.QuoteDAO;
import goit.nz.kickstarter.domain.Quote;

import java.util.List;

import org.hibernate.Query;

public class QuoteDAOImplHibernate extends AbstractHibernateDAO implements
		QuoteDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Quote> getQuotes() {
		Query query = getSession().createQuery("from Quote");
		return (List<Quote>) query.list();
	}

}
