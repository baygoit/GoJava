package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.model.Category;

@Repository
@Transactional
public class CategoryDao {

	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public Category get(Long categoryId) {
		log.info("<Category> get(categoryId = {})...", categoryId);
		Session session = sessionFactory.getCurrentSession();

		return (Category) session.createCriteria(Category.class)
				.add(Restrictions.eq("categoryId", categoryId)).uniqueResult();
	}

	public List<Category> getAll() {
		log.info("<categories> getAll()...");
		Session session = sessionFactory.getCurrentSession();

		return session.createCriteria(Category.class).list();
	}
}
