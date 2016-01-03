package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.hibernate.HibernateUtil;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@SuppressWarnings("unchecked")
	public List<Project> getProjectsFromCategory(int categoryId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("category.id", categoryId));
		List<Project> projects = criteria.list();

		session.close();
		return projects;
	}

	public Project getProjectById(int projectId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("id", projectId));
		Project project = (Project) criteria.uniqueResult();

		session.close();
		return project;
	}

	@Override
	public void add(Project project) {
		// TODO
	}

	@Override
	public void remove(Project project) {
		// TODO
	}
}
