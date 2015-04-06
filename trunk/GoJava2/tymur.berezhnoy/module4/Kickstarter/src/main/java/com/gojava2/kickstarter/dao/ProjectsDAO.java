package com.gojava2.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.ProjectStorage;

@Component
public class ProjectsDAO extends AbstractDAO implements ProjectStorage {
	
	@Override
	public void addProject(Project project) {
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO projects (name, description, story, link, "
				+ "requiredamount, total, days, backers, id_category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
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
		}
	}

	@Override
	public Project getProject(int i) {
		Project result = null;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {			
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
		}
		return result;
	}

	@Override
	public List<Project> getProjects(Category category) {
		List<Project> result = null;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM projects WHERE id_category = " + category.getId());
			result = new ArrayList<Project>();
			while (resultSet.next()) {
				Project projec = new Project(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), 
						resultSet.getInt("requiredAmount"), resultSet.getInt("total"), 
						resultSet.getInt("days"), resultSet.getInt("backers"),
						resultSet.getString("story"), resultSet.getString("link"));
				projec.setCategory(category);
				result.add(projec);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		}
		return result;
	}

	@Override
	public int getSize() {
		int result = 0;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
						
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM projects");
			while (resultSet.next()) {
				result = resultSet.getInt("count");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		}
		return result;
	}
}