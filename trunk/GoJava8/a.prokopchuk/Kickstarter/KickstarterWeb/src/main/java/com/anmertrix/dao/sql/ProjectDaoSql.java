package com.anmertrix.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Project;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	private static final String SELECT_PROJECTS = "SELECT category_id, project.id, name, description, required_budget, final_date, history, url, COALESCE(SUM(amount),0) AS gatheredBudget, days_left FROM project LEFT JOIN payment ON (project.id = payment.project_id) GROUP BY project.id having project.category_id=?";
	private static final String PROJECT_EXISTS = "SELECT count(*) FROM project WHERE id=?";
	private static final String SELECT_PROJECT = "SELECT category_id, project.id, name, description, required_budget, final_date, days_left, history, url, COALESCE(SUM(amount),0) AS gatheredBudget FROM project JOIN payment ON (project.id = payment.project_id) WHERE project_id=?";
	private static final String SELECT_CATEGORY_ID_BY_PROJECT_ID = "SELECT category_id FROM project WHERE id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final class ProjectRowMapper implements RowMapper<Project> {
		public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			Project project = new Project();
			String name = rs.getString("name");
			String description = rs.getString("description");
			int requiredBudget = rs.getInt("required_budget");
			String history = rs.getString("history");
			String url = rs.getString("url");
			int gatheredBudget = rs.getInt("gatheredBudget");
			LocalDate finalDate = rs.getDate("final_date").toLocalDate();
			LocalDate today = LocalDate.now();
			
			int daysLeft = 0;
			if (today.isBefore(finalDate)) {
				daysLeft = (int) ChronoUnit.DAYS.between(today, finalDate);
			}
			
			project.setProjectData(id, name, description, requiredBudget, gatheredBudget, daysLeft, history);
			project.setUrl(url);
			return project;
		}
	}
	
	@Override
	public List<Project> getProjectsByCategoryId(int categoryId) {
		return jdbcTemplate.query(SELECT_PROJECTS, new Object[]{categoryId}, new ProjectRowMapper());
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

	@Override
	public int getCategoryIdByProjectId(int projectId) {
		return jdbcTemplate.queryForObject(SELECT_CATEGORY_ID_BY_PROJECT_ID, new Object[]{projectId}, Integer.class);
	}

}
