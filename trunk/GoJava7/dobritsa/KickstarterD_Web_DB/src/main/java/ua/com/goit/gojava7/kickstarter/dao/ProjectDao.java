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
import ua.com.goit.gojava7.kickstarter.model.Project;

@Repository
@Transactional
public class ProjectDao {

	private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public Project get(Long projectId) {
		log.info("<Project> get({})...", projectId);
		Session session = sessionFactory.getCurrentSession();

		Project project = (Project) session.createCriteria(Project.class)
				.add(Restrictions.eq("projectId", projectId))
				.uniqueResult();

		return project;
	}

	public List<Project> getByCategory(Long categoryId) {
		log.info("<projects> getByCategory({})...", categoryId);
		Session session = sessionFactory.getCurrentSession();

		List<Project> projects = session.createCriteria(Project.class)
				.add(Restrictions.eq("category.id", categoryId))
				.list();

		return projects;
	}
}
