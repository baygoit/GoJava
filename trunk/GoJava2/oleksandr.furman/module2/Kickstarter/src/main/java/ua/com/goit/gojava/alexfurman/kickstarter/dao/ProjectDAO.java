package ua.com.goit.gojava.alexfurman.kickstarter.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;

public class ProjectDAO {

	private SessionFactory sessionFactory;

	public ProjectDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Project> getProjectByCategoryId(int categoryID) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("findProjectByCategoryID");
		query.setInteger("category", categoryID);
		@SuppressWarnings("unchecked")
		List<Project> list = query.list();
		return list;
	}
	
	@Transactional
	public Project getProjectById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Project project = (Project) session.load(Project.class, new Integer(id));
		Hibernate.initialize(project.getName());
		Hibernate.initialize(project.getDescription());
		Hibernate.initialize(project.getGoal());
		Hibernate.initialize(project.getDaysLeft());
		Hibernate.initialize(project.getPledged());
		Hibernate.initialize(project.getLinksToVideo());
		Hibernate.initialize(project.getQuestionAnswers());
		return project;
	}
	
	@Transactional
	public void update(Project project) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.update(project);		
	}
}
