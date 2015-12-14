package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Project;

public class ProjectDaoDb implements ConfigDaoDb, ProjectDao {

	private static final String INSERT_PROJECT = "INSERT INTO projects (id, id_category, name, description, video_link, requirement_sum, collected_sum, days_left) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_PROJECTS = "SELECT id, id_category, name, description, video_link, requirement_sum, collected_sum, days_left FROM projects ORDER BY id";
	private static final String SELECT_COUNT_PROJECTS = "SELECT COUNT(id) FROM projects";
	private static final String SELECT_PROJECTS_BY_CATEGORY = "SELECT id, id_category, name, description, video_link, requirement_sum, collected_sum, days_left FROM projects WHERE id_category = ?";
	private static final String DELETE_PROJECT = "DELETE FROM projects WHERE id = ?";
	
	private Connection connection;

	public ProjectDaoDb(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void add(Project project) {

		try {
			PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT);

			statement.setInt(1, project.getUniqueID());
			statement.setInt(2, project.getCategoryID());
			statement.setString(3, project.getName());
			statement.setString(4, project.getDescription());
			statement.setString(5, project.getUrl());
			statement.setInt(6, project.getNecessaryAmount());
			statement.setInt(7, project.getCollectedAmount());
			statement.setInt(8, project.getEndOfDays());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Project> getAll() {
		List<Project> projects = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PROJECTS);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Project project = new Project();

				project.setUniqueID(resultSet.getInt(1));
				project.setCategoryID(resultSet.getInt(2));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setUrl(resultSet.getString("video_link"));
				project.setNecessaryAmount(resultSet.getInt(6));
				project.setCollectedAmount(resultSet.getInt(7));
				project.setEndOfDays(resultSet.getInt(8));

				projects.add(project);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return projects;
	}

	@Override
	public List<Project> getProjectsFromCategory(int categoryId) {
		List<Project> projects =new ArrayList<>();
		
		try {
			PreparedStatement statement=connection.prepareStatement(SELECT_PROJECTS_BY_CATEGORY);
			statement.setInt(1, categoryId);
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				Project project=new Project();
				
				project.setUniqueID(resultSet.getInt(1));
				project.setCategoryID(resultSet.getInt(2));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setUrl(resultSet.getString("video_link"));
				project.setNecessaryAmount(resultSet.getInt(6));
				project.setCollectedAmount(resultSet.getInt(7));
				project.setEndOfDays(resultSet.getInt(8));
				
				projects.add(project);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return projects;
	}

	@Override
	public int getSize() {
		int countProjects = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_COUNT_PROJECTS);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				countProjects = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return countProjects;
	}

	@Override
	public void remove(Project project) {

		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT);
			statement.setInt(1, project.getUniqueID());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
