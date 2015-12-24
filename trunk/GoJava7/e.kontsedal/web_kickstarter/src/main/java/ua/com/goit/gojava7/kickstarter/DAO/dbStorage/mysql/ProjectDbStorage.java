package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.model.Project;


public class ProjectDbStorage extends AbstractProjectStorage {

	private final String INSERT_PROJECT = "INSERT INTO projects (category_id, name, short_description, description, video, cost_need, deadline) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String SELECT_ALL_PROJECTS = "SELECT id, name FROM categories";
	private final String SELECT_PROJECT = "SELECT * FROM projects WHERE id = ";
	private final String SELECT_PROJECTS_FROM_CATEGORY = "SELECT * FROM projects WHERE category_id = ";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Project> getAll() {
		return jdbcTemplate.query(SELECT_ALL_PROJECTS, new Mapper());
	}

	@Override
	public void add(Project project) {
		jdbcTemplate.batchUpdate(INSERT_PROJECT, new StatementSetter(project));
	}

	@Override
	public Project getProjectById(int projectId) {
		return jdbcTemplate.queryForObject(SELECT_PROJECT + projectId, new Mapper());
	}

	@Override
	public List<Project> getProjectsFromSelectedCategory(int idCategory) {
		return jdbcTemplate.query(SELECT_PROJECTS_FROM_CATEGORY + idCategory, new Mapper());
	}
	

	public class Mapper implements RowMapper<Project> {
		
		@Override
		public Project mapRow(ResultSet resultSet, int index) throws SQLException {
			
			Project project = new Project();
			project.setIdProject(resultSet.getInt("id"));
			project.setIdParentCategory(resultSet.getInt("category_id"));
			project.setProjectName(resultSet.getString("name"));
			project.setProjectShortDescription(resultSet.getString("short_description"));
			project.setProjectDescription(resultSet.getString("description"));
			project.setVideoUrl(resultSet.getString("video"));
			project.setProjectCostNeed(resultSet.getInt("cost_need"));
			project.setDeadline(resultSet.getInt("deadline"));
			return project;
		}
	}
	
	
	public class StatementSetter implements BatchPreparedStatementSetter {
		
		List<Project> projects;
		
		public StatementSetter(Project project) {
			projects = new ArrayList<>();
			projects.add(project);
		}
		
		@Override
		public int getBatchSize() {
			return projects.size();
		}

		@Override
		public void setValues(PreparedStatement statement, int index) throws SQLException {
			Project project = projects.get(index);
			statement.setInt(1, project.getIdParentCategory());
			statement.setString(2, project.getProjectName());
			statement.setString(3, project.getProjectShortDescription());
			statement.setString(4, project.getProjectDescription());
			statement.setString(5, project.getVideoUrl());
			statement.setInt(6, project.getProjectCostNeed());
			statement.setInt(7, project.getProjectDaysLeft());
		}
	}
	
}
