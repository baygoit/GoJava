package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Project;

@Repository
public class ProjectDaoDbImpl implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Project project) {

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsFromCategory(int categoryId) {
		Session session =sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("categories.id", categoryId));
		List<Project> projects = criteria.list();
		
		session.close();
		return projects;
	}

	@Override
	public void remove(Project project) {

	}

	@Override
	public Project getProjectById(int projectId) {
		Session session=sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("id", projectId));
		Project project = (Project) criteria.uniqueResult();
		
		session.close();
		return project;
	}

}
