package goit.nz.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public abstract class AbstractHibernateDAO {

	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void merge(Object entity) {
		getSession().merge(entity);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
