package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectDbDao implements ProjectStorage {
	private Connection connection;

	public ProjectDbDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Project get(int index) {
		Project project = null;
		String query = "select name, descrition, goal, pledged, daysToGo from project where id = " + index;
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String descrition = resultSet.getString("descrition");
				int goal = resultSet.getInt("goal");
				int pledged = resultSet.getInt("pledged");
				int daysToGo = resultSet.getInt("daysToGo");
				project = new Project(name, descrition, goal, pledged, daysToGo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public List<Project> getAll() {
		List<Project> projects = new ArrayList<>();
		String query = "select name, description, goal, pledged, daysToGo from project";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				int goal = resultSet.getInt("goal");
				int pledged = resultSet.getInt("pledged");
				int daysToGo = resultSet.getInt("daysToGo");
				Project project = new Project(name, description, goal, pledged, daysToGo);
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public int size() {
		int size = 0;
		String query = "select count(*) from project";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				size = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

	@Override
	public List<Project> getByCategory(String categoryName) {

		String query = "select name, description, goal, pledged, daysToGo from project where category_id = "
				+ "(select id from category where name = '" + categoryName+ "')";
		List<Project> projects = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				int goal = resultSet.getInt("goal");
				int pledged = resultSet.getInt("pledged");
				int daysToGo = resultSet.getInt("daysToGo");
				Project project = new Project(name, description, goal, pledged, daysToGo);
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

}
