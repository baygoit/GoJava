package ua.com.gojava4.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.gojava4.kickstarter.entities.Project;

public class ProjectsDaoImpl implements ProjectsDao {

	Connection connection;

	public ProjectsDaoImpl(ConnectionPool connectionPool) {
		connection = connectionPool.getConnection();
	}

	@Override
	public List<Project> getAllProjects() {
		return getAllProjectsWithCondition("");
	}

	@Override
	public List<Project> getAllProjectsOfCategory(int categoryId) {
		String condition = " WHERE category_id = " + categoryId;
		return getAllProjectsWithCondition(condition);
	}

	private List<Project> getAllProjectsWithCondition(String condition) {
		String sqlQuery = "SELECT id, category_id, name, short_description, money_goal, pledged, "
				+ "days_to_go, full_description, link FROM Projects;";
		List<Project> projects = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery(sqlQuery);
			while (rs.next()) {
				projects.add(new Project(rs.getInt("id"),
						rs.getInt("category_id"), 
						rs.getString("name"),
						rs.getString("short_description"), 
						rs.getInt("money_goal"),
						rs.getInt("pledged"), 
						rs.getInt("days_to_go"),
						rs.getString("full_description"),
						rs.getString("link"), 
						"Q: A:")
				);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error while reading from DB", e);
		}
		return projects;
	}

}
