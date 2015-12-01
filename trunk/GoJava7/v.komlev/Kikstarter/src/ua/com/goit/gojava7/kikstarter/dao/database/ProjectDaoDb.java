package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Project;

public class ProjectDaoDb implements ProjectDao {

	private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:PROBA";
	private static final String USER_NAME = "MILLER";
	private static final String PASSWORD = "KOLOBOK";
	private static final String INSERT_PROJECT = "INSERT INTO projects (id, id_category, name, description, video_link, requirement_sum, collected_sum, days_left) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_PROJECTS = "SELECT id, id_category, name, description, video_link, requirement_sum, collected_sum, days_left FROM projects ORDER BY id";
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	@Override
	public void add(Project project) {
		connection = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT);

			preparedStatement.setInt(1, project.getUniqueID());
			preparedStatement.setInt(2, project.getCategoryID());
			preparedStatement.setString(3, project.getName());
			preparedStatement.setString(4, project.getDescription());
			preparedStatement.setString(5, project.getUrl());
			preparedStatement.setInt(6, project.getNecessaryAmount());
			preparedStatement.setInt(7, project.getAmountCollected());
			preparedStatement.setInt(8, project.getEndOfDays());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("You have a problem with connection DB!");
			}
		}

	}

	@Override
	public List<Project> getAll() {
		List<Project> projects = new ArrayList<>();

		connection = null;
		statement = null;
		resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_PROJECTS);

			while (resultSet.next()) {
				Project project = new Project();

				project.setUniqueID(resultSet.getInt("id"));
				project.setCategoryID(resultSet.getInt("id_category"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setUrl(resultSet.getString("video_link"));
				project.setNecessaryAmount(resultSet.getInt("requirement_sum"));
				project.setAmountCollected(resultSet.getInt("collected_sum"));
				project.setEndOfDays(resultSet.getInt("days_left"));

				projects.add(project);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("You have a problem with connection DB!");
			}
		}

		return projects;
	}

	@Override
	public List<Project> getProjectsFromCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove(Project project) {
		// TODO Auto-generated method stub

	}

}
