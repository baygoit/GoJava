package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Repository
public class ProjectDaoSqlImpl implements ProjectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Project> getProjects(int categoryId) {

		String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE categoryId = ? "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";			
		return jdbcTemplate.query(sql, new Integer[] { categoryId }, new BeanPropertyRowMapper<Project>(Project.class));
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

		String sql = "SELECT COUNT(*) size FROM project WHERE categoryId = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { categoryId }, Integer.class);
	}

	@Override
	public Project getProject(int projectId) {

		String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE p.id = ? "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";
		return jdbcTemplate.queryForObject(sql, new Integer[] { projectId },
				new BeanPropertyRowMapper<Project>(Project.class));
		
		/*String hql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(payment.pledge) "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE p.id = :projectId "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery(hql);
		query.setFirstResult(1);
		query.setParameter("projectId", projectId);
		List<Project> projects = query.list();
		
		if(projects.size() != 0 ){
			return projects.get(0);
		} else {
			return null;
		}*/
		
		/*DetachedCriteria ownerCriteria = DetachedCriteria.forClass(Payment.class);
		ownerCriteria.setProjection(Property.forName("projectId"));
		ownerCriteria.add(Restrictions.eq("ownername", "bob"));
		
		Criteria criteria = session.createCriteria(Project.class);*/
		/*criteria.setFetchMode("Project.id", FetchMode.JOIN);
		criteria.createAlias("Project.payment", "payment");
		ProjectionList columns = Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("categoryId"))
				.add(Projections.property("name"))
				.add(Projections.property("daysToGo"))
				.add(Projections.property("description"))
				.add(Projections.property("goal"))
				.add(Projections.property("owner"))
				.add(Projections.property("videoUrl"))
				.add(Projections.alias(Projections.sum("payment.pledge"), "amountPledge"));
		criteria.setProjection(columns);

		criteria.add(Restrictions.eq("id", projectId));
		criteria.createAlias("project", "p");
		criteria.createAlias("project.payment", "payment");
		criteria.add(Restrictions.eqProperty("p.id", "payment.projectId"));
		
		criteria.setProjection(Projections.alias(Projections.sum("payment.pledge"), "amountPledge"));*/
		//criteria.createCriteria("payment", "payment", JoinType.LEFT_OUTER_JOIN).add(Restrictions.eq("payment.projectId", "Project.id"));
		
		//criteria.setProjection(columns);
		



		/*criteria.add(Property.forName("ownerId").in(ownerCriteria));
		
		Project project = (Project) criteria.uniqueResult();

		session.close();

		return project;*/
	}

}
