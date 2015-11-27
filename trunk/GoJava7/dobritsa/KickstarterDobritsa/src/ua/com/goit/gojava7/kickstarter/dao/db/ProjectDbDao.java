package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectDbDao implements ProjectStorage {
	private Connection connection;

	public ProjectDbDao(Connection connection) {
		this.connection = connection;
	}

	List<Project> projects = new ArrayList<>();

	@Override
	public Project get(int index) {
		Project project = null;
		String query = "select name, description, goal, pledged, daysToGo, history, link from project where id = "
				+ (index + 1);
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				project = new Project();
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setGoal(resultSet.getInt("goal"));
				project.setPledged(resultSet.getInt("pledged"));
				project.setDaysToGo(resultSet.getInt("daysToGo"));
				project.setHistory(resultSet.getString("history"));
				project.setLink(resultSet.getString("link"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public List<Project> getAll() {
		List<Project> projects = new ArrayList<>();
		String query = "select name, description, goal, pledged, daysToGo, history, link from project";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				Project project = new Project();
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setGoal(resultSet.getInt("goal"));
				project.setPledged(resultSet.getInt("pledged"));
				project.setDaysToGo(resultSet.getInt("daysToGo"));
				project.setHistory(resultSet.getString("history"));
				project.setLink(resultSet.getString("link"));
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
		String query = "select count(*) as cnt from project";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			// if (resultSet.next()) {
			size = resultSet.getInt("cnt");
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

	@Override
	public List<Project> getByCategory(String categoryName) {

		String query = "select name, description, goal, pledged, daysToGo, history, link from project where category_id = "
				+ "(select id from category where name = '" + categoryName + "')";
		List<Project> projects = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				Project project;
				project = new Project();
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setGoal(resultSet.getInt("goal"));
				project.setPledged(resultSet.getInt("pledged"));
				project.setDaysToGo(resultSet.getInt("daysToGo"));
				project.setHistory(resultSet.getString("history"));
				project.setLink(resultSet.getString("link"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public Project getByNumber(int number) {
		return get(number);
	}

	@Override
	public void setAll(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public void addToPledged(String projectName, int amount) {
		String query = "update project set pledged = pledged + " + amount + " where name = '" + prepareStringForDb(projectName) + "'";
		try (PreparedStatement ps = connection.prepareStatement(query); 
				) {
			ps.executeUpdate();
		//	resultSet.updateAsciiStream(columnIndex, x);
		//	resultSet.updateInt("pledget", amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String prepareStringForDb(String original) {	
		return original.replace("'", "\\'");
	}
	
	@Override
	public int getPledged(String projectName) {		
		String query = "select pledged from project where name = '" + prepareStringForDb(projectName) + "'";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {			
				int pledged = resultSet.getInt("pledged");				
				return pledged;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;		
	}

}
