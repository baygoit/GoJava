package ua.com.sas.model;

import java.sql.Connection;
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
	public void addProject(Project project) {
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.execute("INSERT INTO projects (category_id, name, description, money_need, money_has, days_left, history,"
					+ "video_link, question) VALUES (\'" + project.getCategoryId() + "\'," + "\'" + project.getProjectName() + "\',"
					+ "\'" + project.getDescription() + "\'," + "\'" + project.getMoneyNeed()
					+ "\',"	+ "\'" + project.getMoneyHas() + "\'," + "\'" + project.getDaysLeft() + "\'," + "\'" + project.getHistory() 
					+ "\',"	+ "\'" + project.getVideoLink() + "\'," + "\'" + project.getQuestion() + "\'" + ")");
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public Project readObject(int index) {
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT projects.name AS pname, categories.name AS cname, projects.id as pid, "
					+ "* FROM projects INNER JOIN categories ON projects.category_id = categories.id");
			int i = 0;
			Project project = null;
			while (rs.next()){
				if (i == index){
					project = new Project(new Category(rs.getInt("category_id"), rs.getString("cname")));
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
		return categoryProjects.size();
	}

	@Override
	public List<Project> chooseProjects(Category category) {
		try {
			Project project;
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
