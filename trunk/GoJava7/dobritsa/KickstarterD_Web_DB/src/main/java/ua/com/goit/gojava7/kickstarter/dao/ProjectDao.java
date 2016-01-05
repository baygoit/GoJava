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
import ua.com.goit.gojava7.kickstarter.models.Project;

@Repository
public class ProjectDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);
	
	public Project get(Long projectId) {
		log.info("<Project> get({})...", projectId);		
		Session session = sessionFactory.openSession();

		Project project = (Project) session.createCriteria(Project.class)
				.add(Restrictions.eq("projectId", projectId))
				.uniqueResult();

		session.close();
		log.debug("<Project> get({}) returned project: {}", projectId, project);
		return project;
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getByCategory(Category category) {
		log.info("<projects> getByCategory({})...", category);		
		Session session = sessionFactory.openSession();

		List<Project> projects = session.createCriteria(Project.class)
				.add(Restrictions.eq("Category", category))
				.list();

		session.close();
		log.debug("<projects> getByCategory({}) returned projects: {}", category, projects);
		return projects;
	}
}
