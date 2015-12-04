package ua.com.goit.gojava7.kickstarter.dao.mysql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

public class ProjectDaoMysqlImpl implements ProjectDao {
	
	private static final String INSERT_PROJECT = "INSERT INTO projects (category_id, title, brief_description, full_description, "
													+ "video_link, required_sum, collected_sum, days_left) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_PROJECT = "DELETE FROM projects WHERE id = ?";
	private static final String SELECT_ALL_PROJECTS = "SELECT id, category_id, title, brief_description, full_description, "
													+ "video_link, required_sum, collected_sum, days_left FROM projects";
	private static final String COUNT_ALL_PROJECTS = "SELECT count(*) FROM projects";
	private static final String SELECT_PROJECTS_FROM_CATEGORY = "SELECT id, category_id, title, brief_description, full_description, "
													+ "video_link, required_sum, collected_sum, days_left FROM projects WHERE category_id = ?";
	private static final String SELECT_PROJECT_BY_ID = "SELECT id, category_id, title, brief_description, full_description, "
													+ "video_link, required_sum, collected_sum, days_left FROM projects WHERE id = ?";
	
	private Connection connection = null;
	
	public ProjectDaoMysqlImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void add(Project project) {
		
		try (PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT)) {
			
			statement.setInt(1, project.getCategoryID());
			
			statement.setString(2, project.getTitle());
			
			statement.setString(3, project.getBriefDescription());
			
			statement.setString(4, project.getFullDescription());
			
			statement.setString(5, project.getVideoLink());
			
			statement.setInt(6, project.getRequiredSum());
			
			statement.setInt(7, project.getCollectedSum());
			
			statement.setInt(8, project.getDaysLeft());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	@Override
	public void remove(Project project) {
		
		try (PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT)) {
			
			statement.setInt(1, project.getUniqueID());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	@Override
	public List<Project> getAll() {
		
		List<Project> projects = new ArrayList<>();

		try (Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_PROJECTS)) {

			while (resultSet.next()) {
				
				Project project = new Project();
				
				project.setUniqueID(resultSet.getInt("id"));
				
				project.setCategoryID(resultSet.getInt("category_id"));
				
				project.setTitle(resultSet.getString("title"));
				
				project.setBriefDescription(resultSet.getString("brief_description"));
				
				project.setFullDescription(resultSet.getString("full_description"));
				
				project.setVideoLink(resultSet.getString("video_link"));
				
				project.setRequiredSum(resultSet.getInt("required_sum"));
				
				project.setCollectedSum(resultSet.getInt("collected_sum"));
				
				project.setDaysLeft(resultSet.getInt("days_left"));
				
				projects.add(project);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return projects;
	}

	@Override
	public int getSize() {
		
		int amountOfProjects = 0;
		
		try (Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery(COUNT_ALL_PROJECTS)) {

			while (resultSet.next()) {
				
				amountOfProjects = resultSet.getInt(1);
				
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return amountOfProjects;
	}

	@Override
	public List<Project> getProjectsFromCategory(int categoryID) {
		
		List<Project> projectFromCategory = new ArrayList<>();
		
		try (PreparedStatement statement = connection.prepareStatement(SELECT_PROJECTS_FROM_CATEGORY)) {
			
			statement.setInt(1, categoryID);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				Project project = new Project();
				
				project.setUniqueID(resultSet.getInt("id"));
				
				project.setCategoryID(resultSet.getInt("category_id"));
				
				project.setTitle(resultSet.getString("title"));
				
				project.setBriefDescription(resultSet.getString("brief_description"));
				
				project.setFullDescription(resultSet.getString("full_description"));
				
				project.setVideoLink(resultSet.getString("video_link"));
				
				project.setRequiredSum(resultSet.getInt("required_sum"));
				
				project.setCollectedSum(resultSet.getInt("collected_sum"));
				
				project.setDaysLeft(resultSet.getInt("days_left"));
				
				projectFromCategory.add(project);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return projectFromCategory;
	}
	
	@Override
	public Project getProjectById(int projectId) {
		
		Project project = null;
		
		try (PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_BY_ID)) {
			
			statement.setInt(1, projectId);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				project = new Project();
				
				project.setUniqueID(resultSet.getInt("id"));
				
				project.setCategoryID(resultSet.getInt("category_id"));
				
				project.setTitle(resultSet.getString("title"));
				
				project.setBriefDescription(resultSet.getString("brief_description"));
				
				project.setFullDescription(resultSet.getString("full_description"));
				
				project.setVideoLink(resultSet.getString("video_link"));
				
				project.setRequiredSum(resultSet.getInt("required_sum"));
				
				project.setCollectedSum(resultSet.getInt("collected_sum"));
				
				project.setDaysLeft(resultSet.getInt("days_left"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return project;
	}
}
