package belskii.artem.kickstarter.dao.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class CategoryDaoImplHiber implements CategoryDao {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private int getNextId() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session
			    .createCriteria(Category.class)
			    .setProjection(Projections.max("categoryId"));
			Integer maxId = (Integer)criteria.uniqueResult();
			session.close();
			if (maxId==null){
				maxId=0;
			}
			return maxId+1;
	}

	@Override
	public void addCategory(String categoryInfo) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = new Category(this.getNextId(), categoryInfo);
		session.save(category);
		session.getTransaction().commit();
		session.close();

		
	}

	@Override
	public Map<Integer, String> getCategoryList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Category.class);
		ArrayList<Category> category = (ArrayList<Category>) criteria.list();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; category.size() > i; i++) {
			map.put(i, category.get(i).getCategoryName());
		}
		session.getTransaction().commit();
		return map;
	}

	@Override
	public String getCategoryNameById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = session.get(Category.class, id);
		return category.getCategoryName();
	}

	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub
		
	}

}
