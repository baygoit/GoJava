package com.gojava2.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.ProjectStorage;

public class ProjectsDAO implements ProjectStorage {

	private Connection connection;
	
	public ProjectsDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addProject(Project project) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("INSERT INTO categories (name) VALUES (?)");
			statement.setString(1, project.getCategory().getName());
			statement.execute();
			
			statement = connection.prepareStatement("INSERT INTO projects (name, description, story, link, "
													+ "requiredamount, total, days, backers, id_category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setString(3, project.getStory());
			statement.setString(4, project.getLink());
			statement.setInt(5, project.getRequiredAmount());
			statement.setInt(6, project.getTotal());
			statement.setInt(7, project.getDays());
			statement.setInt(8, project.getBackers());
			statement.setInt(9, project.getCategory().getId());
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Can't add new project", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
	}

	@Override
	public Project getProject(int i) {
		Statement statement = null;
		Project result = null;
		
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT *, categories.id AS category_id, categories.name AS category_name "
														+ "FROM projects INNER JOIN categories "
														+ "ON categories.id = projects.id_category WHERE projects.id = " + i);
			while (resultSet.next()) {
			result = new Project(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), 
					resultSet.getInt("requiredAmount"), resultSet.getInt("total"), 
					resultSet.getInt("days"), resultSet.getInt("backers"),
					resultSet.getString("story"), resultSet.getString("link"));
			
			Category category = new Category(resultSet.getInt("category_id"), resultSet.getString("category_name"));
			result.setCategory(category);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} finally {
			try {
				if(statement != null) {
				statement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return result;
	}

	@Override
	public List<Project> getProjects(Category category) {
		Statement statement = null;
		List<Project> result = null;
		Project projec = null;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM projects WHERE id_category = " + category.getId());
			result = new ArrayList<Project>();
			while (resultSet.next()) {
				projec = new Project(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), 
						resultSet.getInt("requiredAmount"), resultSet.getInt("total"), 
						resultSet.getInt("days"), resultSet.getInt("backers"),
						resultSet.getString("story"), resultSet.getString("link"));
				projec.setCategory(category);
				result.add(projec);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return result;
	}

	@Override
	public int getSize() {
		int result = 0;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS COUNT FROM projects");
			while (resultSet.next()) {
				result = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return result;
	}
}