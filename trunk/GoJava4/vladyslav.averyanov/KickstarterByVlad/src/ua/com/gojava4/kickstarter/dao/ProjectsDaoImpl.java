package ua.com.gojava4.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Quote;

public class ProjectsDaoImpl implements ProjectsDao {

	
	Connection connection;

	public ProjectsDaoImpl(ConnectionPool connectionPool) {
		connection = connectionPool.getConnection();
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllProjectsOfCategory(int categoryId) {
		List<Project> projects = new ArrayList<>();
		try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT id, category_id, name, short_description, money_goal, pledged, days_to_go, full_description, link FROM Categories;");
			while (rs.next()){
				projects = add(new Project(rs.getString("context"), rs.getString("author")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projects;
	}

}
