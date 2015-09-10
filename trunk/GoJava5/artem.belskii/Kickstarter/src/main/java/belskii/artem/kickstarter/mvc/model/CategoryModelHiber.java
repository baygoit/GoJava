package belskii.artem.kickstarter.mvc.model;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import belskii.artem.kickstarter.dao.category.Category;

public class CategoryModelHiber {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
//	private int getNextId() {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Criteria criteria = session
//			    .createCriteria(Category.class)
//			    .setProjection(Projections.max("categoryId"));
//			Integer maxId = (Integer)criteria.uniqueResult();
//			session.close();
//			if (maxId==null){
//				maxId=0;
//			}
//			return maxId+1;
//	}


	public void addCategory(String categoryInfo) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = new Category(categoryInfo);
		session.save(category);
		session.getTransaction().commit();
		session.close();

		
	}


	public Map<Integer, String> getCategoryList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Object[]arr = session.createCriteria(Category.class).list().toArray();
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		for (int i=0;arr.length>i;i++) {
			map.put(i,arr[i].toString());
		}
		return map;
	}


	public String getCategoryNameById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = session.get(Category.class, id);
		return category.getCategoryName();
	}


	public void initDemoDB() {
		// TODO Auto-generated method stub
		
	}

}
