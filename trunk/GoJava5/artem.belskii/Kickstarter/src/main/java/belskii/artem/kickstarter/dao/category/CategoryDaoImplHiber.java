package belskii.artem.kickstarter.dao.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CategoryDaoImplHiber implements CategoryDao {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private int getNextId() {
		Integer maxId = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Category.class).setProjection(Projections.max("categoryId"));
			maxId = (Integer) criteria.uniqueResult();
			if (maxId == null) {
				maxId = 0;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return maxId + 1;
	}

	@Override
	public void addCategory(String categoryInfo) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Category category = new Category(this.getNextId(), categoryInfo);
			session.saveOrUpdate(category);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public Map<Integer, String> getCategoryList() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Category.class);
			ArrayList<Category> category = (ArrayList<Category>) criteria.list();
			for (int i = 0; category.size() > i; i++) {
				map.put(i, category.get(i).getCategoryName());
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return map;
	}

	@Override
	public String getCategoryNameById(int id) {
		Category category = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			category = session.get(Category.class, id);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return category.getCategoryName();
	}

	@Override
	public int getCaterogyIdByName(String categoryName) {
		int result = -1;
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (int) session.createCriteria(Category.class).add(Restrictions.eq("categoryName", categoryName)).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub

	}

}
