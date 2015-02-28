package ua.com.sas.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO implements Projects{
	private Connection connection;

	public ProjectsDAO(ConnectionDAO connectionDAO){
		connection = connectionDAO.getConnection();
	}

	@Override
	public void addProject(Project project) {
		// TODO This is not need for now
	}

	@Override
	public Project readObject(int index) {
		Statement statement;
		try {
			statement = connection.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery("select * from projects");
		int i = 0;
		Project project = null;
			while (rs.next()){
				if (i == index){
					project = new Project(new Category(rs.getInt("category_id")));
					project.setProject(rs.getString("name"), rs.getString("description"), rs.getInt("money_need"), rs.getInt("money_has"),
							rs.getInt("days_left"), rs.getString("history"), rs.getString("video_link"), rs.getString("question"));
				}
				i++;
			}
		return project;
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		}
	}

	@Override
	public int getLenth() {
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("select count(*) from projects");
			int size = 0;
			while (rs.next()){
				size = rs.getInt(1);
			}
			return size;
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		}
	}

	@Override
	public List<Project> chooseProjects(Category category) {
		try {
			Project project;
			List<Project> categoryProjects = new ArrayList<Project>();
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT * FROM projects INNER JOIN categories ON category_id = categories.id WHERE categories.id = " + category.getId());
			while (rs.next()){
				project = new Project(category);
				project.setProject(rs.getString("name"), rs.getString("description"), rs.getInt("money_need"), rs.getInt("money_has"),
						rs.getInt("days_left"), rs.getString("history"), rs.getString("video_link"), rs.getString("question"));
				categoryProjects.add(project);
			}
			return categoryProjects;
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		}
	}
}
