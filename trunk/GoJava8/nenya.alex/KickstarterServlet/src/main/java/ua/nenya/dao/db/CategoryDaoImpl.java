package ua.nenya.dao.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;
import ua.nenya.util.HibernateUtil;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		List<Category> categories = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Category.class);
			criteria.addOrder(Order.asc("name"));
			categories = criteria.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public boolean isCategoryExist(int categoryId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		long count = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.eq("id", categoryId));
			count = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return count == 1;
	}

}
