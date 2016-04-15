package com.anmertrix.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Project;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	private static final String SELECT_PROJECTS = "SELECT id, name FROM project WHERE category_id=?";
	private static final String PROJECT_EXISTS = "SELECT count(*) FROM project WHERE id=?";
	private static final String SELECT_PROJECT = "SELECT project.id, name, description, required_budget, days_left, history, url, COALESCE(SUM(amount),0) AS sum_amount FROM project JOIN payment ON (project.id = payment.project_id) WHERE project_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final class ProjectRowMapper implements RowMapper<Project> {
		public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			Project project = new Project();
			String name = rs.getString("name");
			String description = rs.getString("description");
			int required_budget = rs.getInt("required_budget");
			int days_left = rs.getInt("days_left");
			String history = rs.getString("history");
			String url = rs.getString("url");
			int gathered_budget = rs.getInt("sum_amount");
				
			project.setProjectData(id, name, description, required_budget, gathered_budget, days_left, history);
			project.setUrl(url);
			return project;
		}
	}
	
	@Override
	public List<Project> getProjectsByCategoryId(int categoryId) {
		return jdbcTemplate.query(SELECT_PROJECTS, new Object[]{categoryId}, new BeanPropertyRowMapper<Project>(Project.class));
	}
	
	@Override
	public boolean projectExists(int projectId){
		int count = jdbcTemplate.queryForObject(PROJECT_EXISTS, new Object[]{projectId}, Integer.class);
		return count > 0;
	}
	
	@Override
	public Project getProjectById(int projectId) {
		return jdbcTemplate.queryForObject(SELECT_PROJECT, new Object[]{projectId}, new ProjectRowMapper());
	}

}
