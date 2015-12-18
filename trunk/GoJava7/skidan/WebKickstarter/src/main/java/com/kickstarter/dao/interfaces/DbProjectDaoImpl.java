package com.kickstarter.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kickstarter.model.Project;

@Repository
public class DbProjectDaoImpl implements ProjectDaoInterface {

	private static final Logger log = LoggerFactory.getLogger(DbProjectDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Project getOne(int projectNumber) {
		log.info("Project getOne started with arg :" + projectNumber);
		String sql = "select projectId,title,discription,daysLeft,requiredSum,gainedSum,projectHistory,videoLink,categoryTitle from projects where projectId =  ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { projectNumber }, new ProjectMapper());
	}

	public void update(Project p) {
		log.info("Project UPDATE started with project :" + p.getTitle());
		String sql = "update projects set discription = ? , daysLeft = ?, requiredSum = ?, gainedSum = ?,"
				+ " projectHistory = ?, videoLink = ? where projectId = ? ";
		jdbcTemplate.update(sql, new Object[] { p.getDiscription(), p.getDaysLeft(), p.getRequiredSum(),
				p.getGainedSum(), p.getProjectHistory(), p.getVideoLink(), p.getId() });
	}

	public List<Project> getAll(String categoryTitle) {
		log.info("Project getAll started with arg :" + categoryTitle);
		String sql = "select projectId,title,discription,daysLeft,requiredSum,gainedSum,projectHistory,videoLink,"
				+ "categoryTitle from projects where categoryTitle = ?";
		return jdbcTemplate.query(sql, new Object[] { categoryTitle }, new ProjectMapper());
	}

	public final class ProjectMapper implements RowMapper<Project> {

		public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
			Project project = new Project();
			project.setId(rs.getInt("projectId"));
			project.setTitle(rs.getString("title"));
			project.setDiscription(rs.getString("discription"));
			project.setDaysLeft(rs.getInt("daysLeft"));
			project.setRequiredSum(rs.getInt("requiredSum"));
			project.setGainedSum(rs.getInt("gainedSum"));
			project.setProjectHistory(rs.getString("projectHistory"));
			project.setVideoLink(rs.getString("videoLink"));
			project.setCategoryName(rs.getString("categoryTitle"));
			return project;

		}

	}

}
