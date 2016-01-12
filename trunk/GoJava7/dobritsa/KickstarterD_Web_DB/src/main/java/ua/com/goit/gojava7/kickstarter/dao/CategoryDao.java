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
import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;

@Repository
@Transactional
public class CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProjectDao projectDao;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

	public Category get(Long categoryId) {
		log.info("<Category> get({})...", categoryId);
		Session session = sessionFactory.getCurrentSession();

		Category category = (Category) session.createCriteria(Category.class)
				.add(Restrictions.eq("categoryId", categoryId)).uniqueResult();

		//session.close();
		//log.debug("<Category> get({}) returned category: {}", categoryId, category);
		return category;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		log.info("<categories> getAll()...");
		Session session = sessionFactory.getCurrentSession();

		List<Category> categories = session.createCriteria(Category.class)
				.list();

		//session.close();
		//log.debug("<categories> getAll() returned categories: {}", categories);

		return categories;
	}

	public List<Project> getProjects(Long categoryId) {
		log.info("<projects> getProjects({})...", categoryId);
		return projectDao.getByCategory(categoryId);
	}
}
