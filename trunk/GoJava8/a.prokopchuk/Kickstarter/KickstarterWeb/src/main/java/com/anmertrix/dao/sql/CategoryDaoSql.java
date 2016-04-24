package com.anmertrix.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;
import com.anmertrix.dao.sql.HibernateUtil;

@Repository
public class CategoryDaoSql implements CategoryDao {

	@Override
	public Category getCategory(long categoryId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Category category = null;
		try (Session session = sessionFactory.openSession()) {
			category = session.get(Category.class, categoryId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public boolean categoryExists(long categoryId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		int count = 0;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.eq("id", categoryId));
			criteria.setProjection(Projections.rowCount());
			count = ((Number) criteria.uniqueResult()).intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return count > 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Category> categories = null;
		try (Session session = sessionFactory.openSession()) {
			ThreadLocalSessionContext.bind(session);
			categories = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return categories;
	}

}
