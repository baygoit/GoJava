package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava.kickstarter.data.Projects;
import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Project;

@Repository
public class ProjectsDao extends AbstractDao implements Projects {

	@Override
	public List<Project> getProjects(int id) {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM  Project WHERE category_id = "+id);
		return query.list();
	}

	@Override
	public Project get(int id) {
		Session session = getCurrentSession();
		Project project = (Project) session.get(Project.class, id);
		return project;
	}

	@Override
	public int size() {
		Session session = getCurrentSession();
		Number n = (Number) session.createCriteria(Project.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return n.intValue();
	}

}
