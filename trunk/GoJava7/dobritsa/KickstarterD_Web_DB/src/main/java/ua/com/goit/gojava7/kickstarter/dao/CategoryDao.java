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
import ua.com.goit.gojava7.kickstarter.model.Project;

@Repository
@Transactional
public class CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProjectDao projectDao;

	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

	public Category get(Long categoryId) {
		log.info("<Category> get({})...", categoryId);
		Session session = sessionFactory.getCurrentSession();

		return (Category) session.createCriteria(Category.class)
				.add(Restrictions.eq("categoryId", categoryId)).uniqueResult();
	}

	public List getAll() {
		log.info("<categories> getAll()...");
		Session session = sessionFactory.getCurrentSession();

		return session.createCriteria(Category.class).list();
	}

	public List<Project> getProjects(Long categoryId) {
		log.info("<projects> getProjects({})...", categoryId);
		return projectDao.getByCategory(categoryId);
	}
}
