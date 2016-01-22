package com.kickstarter.dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.Interfaces.ProjectDao;
import com.kickstarter.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Project> getAllProjectsForCategory(int categoryId) {
		return 	entityManager.createQuery("from Project where categoryId= :categoryId")
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Transactional(readOnly = true)
	public Project getOneProject(int projectNumber) {
		return entityManager.find(Project.class, projectNumber);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, readOnly = false)
	public void updateProject(Project project) {
		entityManager.merge(project);
	}

}






















// Project project = (Project) session.createQuery(sql).uniqueResult();

// final String sql = "from Project where projectId=" + projectNumber;

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
