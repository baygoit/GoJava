package com.anmertrix.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;

@Repository
public class CategoryDaoSql implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
	public Category getCategory(long categoryId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Category.class, categoryId);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean categoryExists(long categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", categoryId));
		criteria.setProjection(Projections.rowCount());
		long count = (long) criteria.uniqueResult();
		return count > 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		Session session = sessionFactory.openSession();
		return	session.createCriteria(Category.class).list();
	}

}
