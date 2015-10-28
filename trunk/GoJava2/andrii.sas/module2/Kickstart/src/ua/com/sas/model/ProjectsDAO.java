package ua.com.sas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO implements Projects{
	private Connection connection;
	private List<Project> categoryProjects = new ArrayList<Project>();

	public ProjectsDAO(ConnectionDAO connectionDAO){
		connection = connectionDAO.getConnection();
	}

	@Override
	public void add(Project project) {
		try {
			Statement stat = connection.createStatement();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO projects (category_id, name, description, money_need,"
					+ " money_has, days_left, history, video_link, question) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, project.getCategoryId());
			statement.setString(2, project.getName());
			statement.setString(3, project.getDescription());
			statement.setInt(4, project.getMoneyNeed());
			statement.setInt(5, project.getMoneyHas());
			statement.setInt(6, project.getDaysLeft());
			statement.setString(7, project.getHistory());
			statement.setString(8, project.getVideoLink());
			statement.setString(9, project.getQuestion());
			statement.execute();
			ResultSet rs = stat.executeQuery("SELECT * FROM projects WHERE name = \'" + project.getName() + "\'");
			while (rs.next()){
				project.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public Project get(int id) {
		Statement statement;
		Project project = null;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT projects.name AS pname, categories.name AS cname, "
					+ "projects.id as pid, * FROM projects INNER JOIN categories ON projects.category_id = categories.id"
					+ " WHERE projects.id =" + id);
			while (rs.next()){
				project = new Project(rs.getInt("pid"), new Category(rs.getInt("category_id"), rs.getString("cname")));
				initProject(rs, project);
			}
		return project;
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		}
	}

	private void initProject(ResultSet rs, Project project) {
		try {
			project.setProject(rs.getString("name"), rs.getString("description"), rs.getInt("money_need"), rs.getInt("money_has"),
					rs.getInt("days_left"), rs.getString("history"), rs.getString("video_link"), rs.getString("question"));
			project.setCategoryId(rs.getInt("category_id"));
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		}
	}

	@Override
	public int size() {
		return categoryProjects.size();
	}

	@Override
	public List<Project> getProjects(Category category) {
		try {
			categoryProjects.clear();
			Project project;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT projects.id as pid, * FROM projects INNER JOIN categories ON category_id = categories.id WHERE categories.id = " + category.getId());
			while (rs.next()){
					project = new Project(rs.getInt("pid"), category);
					initProject(rs, project);
					categoryProjects.add(project);
			}
			return categoryProjects;
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		}
	}
}
