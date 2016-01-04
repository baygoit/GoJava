package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.hibernate.HibernateUtil;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Category.class);
		List<Category> categories = criteria.list();

		return categories;
	}

	public Category getCategoryById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", id));
		Category category = (Category) criteria.uniqueResult();

		session.close();
		return category;
	}

	public void add(Category category) {
		// TODO
	}

	public void remove(Category category) {
		// TODO
	}
}
