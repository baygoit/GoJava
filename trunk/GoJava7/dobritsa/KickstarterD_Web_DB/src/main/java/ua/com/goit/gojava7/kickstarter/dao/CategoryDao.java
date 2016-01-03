package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.models.Category;

import java.util.List;

@Repository
public class CategoryDao {

	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

	public CategoryDao() {
		log.info("Constructor CategoryDao()...");
	}

	public Category get(Long categoryId) {
		log.info("<Category> get({})...", categoryId);
		Session session = HibernateUtil.getSessionFactory().openSession();

		Category category = (Category) session.createCriteria(Category.class)
				.add(Restrictions.eq("categoryId", categoryId)).uniqueResult();

		session.close();
		log.debug("<Category> get({}) returned category: {}", categoryId, category);
		return category;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		log.info("<categories> getAll()...");
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Category> categories = session.createCriteria(Category.class)
				.add(Restrictions.naturalId()).list();

		session.close();
		log.debug("<categories> getAll() returned categories: {}", categories);
		return categories;
	}
}
