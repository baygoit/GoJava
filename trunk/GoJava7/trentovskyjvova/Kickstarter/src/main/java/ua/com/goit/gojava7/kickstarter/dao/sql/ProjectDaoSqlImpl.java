package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Repository
@Transactional
public class ProjectDaoSqlImpl implements ProjectDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override	
	public List<Project> getProjects(int categoryId) {

		String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE categoryId = :categoryId "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";			
		
		Session session = sessionFactory.getCurrentSession();

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Project.class);
		query.setParameter("categoryId", categoryId);
		
/*		Criteria criteria = session.createCriteria(Project.class, "proj");
		criteria.createAlias("Payment", "pay", JoinType.LEFT_OUTER_JOIN); 
		criteria.setProjection(Projections.sum("pay.pledge").as("amountPledge"));
		criteria.add(Restrictions.eq("categoryId", categoryId));*/
		List<Project> projects = query.list();
		
		return projects;
	}

	@Override
	public Project getProject(int userChoise, int categoryId) {
		if (userChoise == 0) {
			return null;
		} else {
			List<Project> projects = getProjects(categoryId);
			return projects.get(userChoise - 1);
		}
	}

	@Override
	public int size(int categoryId) {
		
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("categoryId", categoryId));
		criteria.setProjection(Projections.rowCount());

		int size = (int) criteria.uniqueResult();
		
		return size;
	}

	@Override
	public Project getProject(int projectId) {

		String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE p.id = :projectId "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";
		
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Project.class);
		query.setParameter("projectId", projectId);
		
		Project project = (Project) query.uniqueResult();
		
		return project;
		
	}

}
