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
	private Session session = null;
	private Transaction transaction = null;
	private Category category = null;

	private int getNextId() {
		Integer maxId = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
			Criteria criteria = session.createCriteria(Category.class).setProjection(Projections.max("categoryId"));
			maxId = (Integer) criteria.uniqueResult();
			if (maxId == null) {
				maxId = 0;
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return maxId + 1;
	}

	@Override
	public void addCategory(String categoryInfo) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
			Category category = new Category(this.getNextId(), categoryInfo);
			session.save(category);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public Map<Integer, String> getCategoryList() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
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
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
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

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
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
