package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getAll() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Category.class);
		List<Category> categories = (List<Category>) criteria.list();

		return categories;
	}

	@Override
	public Category get(Long categoryId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Category.class, categoryId);
	}

}
