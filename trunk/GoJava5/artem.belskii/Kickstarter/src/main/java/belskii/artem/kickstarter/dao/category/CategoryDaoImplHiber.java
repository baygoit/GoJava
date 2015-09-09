package belskii.artem.kickstarter.dao.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl.CriterionEntry;

import belskii.artem.kickstarter.dao.quote.Quote;


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
		
		Object[]arr = session.createCriteria(Category.class).list().toArray();
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		for (int i=0;arr.length>i;i++) {
			map.put(i,arr[i].toString());
		}
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
