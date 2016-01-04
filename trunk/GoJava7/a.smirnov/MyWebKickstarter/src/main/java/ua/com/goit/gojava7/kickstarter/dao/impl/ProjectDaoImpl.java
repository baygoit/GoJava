package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Project> getProjectsFromCategory(int categoryId) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("category.id", categoryId));
		List<Project> projects = criteria.list();

		return projects;
	}

	@Transactional
	public Project getProjectById(int projectId) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("id", projectId));
		Project project = (Project) criteria.uniqueResult();

		return project;
	}

	public void add(Project project) {
		// TODO
	}

	public void remove(Project project) {
		// TODO
	}
}
