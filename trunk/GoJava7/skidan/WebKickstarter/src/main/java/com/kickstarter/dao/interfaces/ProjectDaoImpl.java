package com.kickstarter.dao.interfaces;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.kickstarter.hibernate.HibernateUtil;
import com.kickstarter.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@SuppressWarnings("unchecked")
	public List<Project> getAll(int categoryId) {
		final String sql = "from Project  where categoryId=" + categoryId;
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Project> projectList = session.createQuery(sql).list();
		if (projectList.isEmpty()) {
			return null;
		}
		session.close();
		return projectList;
	}

	public Project getOne(int projectNumber) {
		// final String sql = "from Project where projectId=" + projectNumber;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Project project = (Project) session.get(Project.class, projectNumber);
		// Project project = (Project) session.createQuery(sql).uniqueResult();
		session.close();
		return project;
	}

	public void update(Project project) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(project);
		session.getTransaction().commit();
		session.close();
	}

}
















/*
 * @Autowired private JdbcTemplate jdbcTemplate;
 * 
 * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
 * 
 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
 * jdbcTemplate; }
 */

/*
 * public final class ProjectMapper implements RowMapper<Project> {
 * 
 * public Project mapRow(ResultSet rs, int rowNum) throws SQLException { Project
 * project = new Project(); project.setId(rs.getInt("projectId"));
 * project.setTitle(rs.getString("title"));
 * project.setDiscription(rs.getString("discription"));
 * project.setDaysLeft(rs.getInt("daysLeft"));
 * project.setRequiredSum(rs.getInt("requiredSum"));
 * project.setGainedSum(rs.getInt("gainedSum"));
 * project.setProjectHistory(rs.getString("projectHistory"));
 * project.setVideoLink(rs.getString("videoLink"));
 * project.setCategoryId(rs.getInt("categoryId")); return project;
 * 
 * }
 * 
 * }
 */
/*
 * public List<Project> getAll(int categoryId) { log.info(
 * "Project getAll started with arg :" + categoryId); String sql =
 * "select projectId,title,discription,daysLeft,requiredSum,gainedSum,projectHistory,videoLink,"
 * + "categoryId from projects where categoryId = ?"; return
 * jdbcTemplate.query(sql, new Object[] { categoryId }, new ProjectMapper()); }
 */
/*
 * public Project getOne(int projectNumber) { log.info(
 * "Project getOne started with arg :" + projectNumber); String sql =
 * "select projectId,title,discription,daysLeft,requiredSum,gainedSum,projectHistory,videoLink,categoryId from projects where projectId =  ?"
 * ; return jdbcTemplate.queryForObject(sql, new Object[] { projectNumber }, new
 * ProjectMapper()); }
 */

/*
 * public void update(Project p) { String sql =
 * "update projects set discription = ? , daysLeft = ?, requiredSum = ?, gainedSum = ?,"
 * + " projectHistory = ?, videoLink = ? where projectId = ? ";
 * jdbcTemplate.update(sql, new Object[] { p.getDiscription(), p.getDaysLeft(),
 * p.getRequiredSum(), p.getGainedSum(), p.getProjectHistory(),
 * p.getVideoLink(), p.getId() }); }
 */
