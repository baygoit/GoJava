package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;

@Repository
public class CategoryDaoDbImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Category category) {
		
	}

	@Override
	public void remove(Category category) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		Session session=sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Category.class);
		List<Category> categories=criteria.list();
		
		session.close();
		return categories;
	}


	@Override
	public Category getCategory(int id) {
		Session session=sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", id));
		Category category=(Category) criteria.uniqueResult();

		session.close();
		return category;
	}

}
