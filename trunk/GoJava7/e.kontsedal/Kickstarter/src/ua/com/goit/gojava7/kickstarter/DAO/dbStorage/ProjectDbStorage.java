package ua.com.goit.gojava7.kickstarter.DAO.dbStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectDbStorage extends AbstractProjectStorage {

	private final String INSERT_PROJECT = "INSERT INTO projects (category_id, name, short_description, description, video, cost_need, deadline) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String SELECT_ALL_PROJECTS = "SELECT id, name FROM categories";
	private final String SELECT_PROJECT = "SELECT category_id, name, short_description, description, video, cost_need, deadline FROM projects WHERE id = ";
	private final String SELECT_PROJECTS_FROM_CATEGORY = "SELECT id, name, short_description, description, video, cost_need, deadline FROM projects WHERE category_id = ";

	@Override
	public List<Project> getAll() {
		List<Project> projects = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, DBLOGIN, DBPASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_PROJECTS);

			while (resultSet.next()) {
				Project project = new Project();
				project.setIdProject(resultSet.getInt("id"));
				project.setIdParentCategory(resultSet.getInt("category_id"));
				project.setProjectName(resultSet.getString("name"));
				project.setProjectShortDescription(resultSet.getString("short_description"));
				project.setProjectDescription(resultSet.getString("description"));
				project.setVideoUrl(resultSet.getString("video"));
				project.setProjectCostNeed(resultSet.getInt("cost_need"));
				project.setDeadline(resultSet.getInt("deadline"));
				projects.add(project);
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem");
		}
		return projects;
	}

	@Override
	public void add(Project project) {
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, DBLOGIN, DBPASSWORD);
			PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT);
			statement.setInt(1, project.getIdParentCategory());
			statement.setString(2, project.getProjectName());
			statement.setString(3, project.getProjectShortDescription());
			statement.setString(4, project.getProjectDescription());
			statement.setString(5, project.getVideoUrl());
			statement.setInt(6, project.getProjectCostNeed());
			statement.setInt(7, project.getProjectDaysLeft());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("DB writing problem");
		}
	}

	@Override
	public int getIdOfProject(int projectNumber) {
		return getAll().get(projectNumber).getIdProject();
	}

	@Override
	public Project getProjectById(int projectId) {
		Project project = null;
		try {
			project = new Project();
			Connection connection = DriverManager.getConnection(DATABASE_URL, DBLOGIN, DBPASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_PROJECT + projectId);
			while (resultSet.next()) {
				project.setIdProject(projectId);
				project.setIdParentCategory(resultSet.getInt("category_id"));
				project.setProjectName(resultSet.getString("name"));
				project.setProjectShortDescription(resultSet.getString("short_description"));
				project.setProjectDescription(resultSet.getString("description"));
				project.setVideoUrl(resultSet.getString("video"));
				project.setProjectCostNeed(resultSet.getInt("cost_need"));
				project.setDeadline(resultSet.getInt("deadline"));
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem");
		}
		return project;
	}

	@Override
	public List<Project> getProjectsFromSelectedCategory(int idCategory) {
		List<Project> projects = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, DBLOGIN, DBPASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_PROJECTS_FROM_CATEGORY + idCategory);
			Project project = new Project();
			while (resultSet.next()) {
				project.setIdProject(resultSet.getInt("id"));
				project.setIdParentCategory(idCategory);
				project.setProjectName(resultSet.getString("name"));
				project.setProjectShortDescription(resultSet.getString("short_description"));
				project.setProjectDescription(resultSet.getString("description"));
				project.setVideoUrl(resultSet.getString("video"));
				project.setProjectCostNeed(resultSet.getInt("cost_need"));
				project.setDeadline(resultSet.getInt("deadline"));
				projects.add(project);
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem 111");
		}
		return projects;
	}

}
