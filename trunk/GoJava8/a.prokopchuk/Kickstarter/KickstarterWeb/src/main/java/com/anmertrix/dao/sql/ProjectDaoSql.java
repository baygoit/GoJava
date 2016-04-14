package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.NoResultException;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Project;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	private static final String SELECT_PROJECTS = "SELECT id, name FROM project WHERE category_id=?";
	private static final String PROJECT_EXISTS = "SELECT * FROM project WHERE id=?";
	private static final String SELECT_PROJECT = "SELECT name, description, required_budget, days_left, history, url, COALESCE(SUM(amount),0) AS sum_amount FROM project JOIN payment ON (project.id = payment.project_id) WHERE project_id=?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Project> getProjectsByCategoryId(int categoryId) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PROJECTS)) {
			statement.setInt(1, categoryId);
			ResultSet rs = statement.executeQuery();
			List<Project> projects = new ArrayList<Project>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Project project = new Project();
				project.setId(id);
				project.setName(name);
				projects.add(project);
			}
			return projects;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public boolean projectExists(int projectId){
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(PROJECT_EXISTS)) {
			statement.setInt(1, projectId);
			ResultSet rs = statement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public Project getProjectById(int projectId) {
		Project project = new Project();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT)) {
			statement.setInt(1, projectId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int required_budget = rs.getInt("required_budget");
				int days_left = rs.getInt("days_left");
				String history = rs.getString("history");
				String url = rs.getString("url");
				int gathered_budget = rs.getInt("sum_amount");
					
				project.setProjectData(projectId, name, description, required_budget, gathered_budget, days_left, history);
				project.setUrl(url);
				return project;
			} else {
				throw new NoResultException("No project found");
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
