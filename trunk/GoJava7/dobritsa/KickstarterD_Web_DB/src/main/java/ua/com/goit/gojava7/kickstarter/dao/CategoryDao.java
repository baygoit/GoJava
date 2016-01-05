package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

	public Category get(Long categoryId) {
		log.info("<Category> get({})...", categoryId);
		Session session = sessionFactory.openSession();

		Category category = (Category) session.createCriteria(Category.class)
				.add(Restrictions.eq("categoryId", categoryId)).uniqueResult();

		session.close();
		log.debug("<Category> get({}) returned category: {}", categoryId, category);
		return category;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		log.info("<categories> getAll()...");
		Session session = sessionFactory.openSession();

		List<Category> categories = session.createCriteria(Category.class)
				.add(Restrictions.naturalId()).list();

		session.close();
		log.debug("<categories> getAll() returned categories: {}", categories);
		return categories;
	}
}
