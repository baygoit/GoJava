package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Project;

@Repository
public class ProjectDaoDbImpl implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Project> getProjectsFromCategory(int categoryId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("category.id", categoryId));
		List<Project> projects = criteria.list();

		return projects;
	}

	@Transactional
	@Override
	public Project getProjectById(int projectId) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("id", projectId));
		Project project = (Project) criteria.uniqueResult();

		return project;
	}
	
	@Override
	public void remove(Project project) {

	}
	
	@Override
	public void add(Project project) {

	}
}
