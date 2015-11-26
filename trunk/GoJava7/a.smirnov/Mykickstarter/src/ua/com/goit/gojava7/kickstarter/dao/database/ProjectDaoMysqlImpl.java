package ua.com.goit.gojava7.kickstarter.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractProjectDao;

public class ProjectDaoMysqlImpl extends AbstractProjectDao {
	
	@Override
	public void add(Project project) {
		String insertPrject = "INSERT INTO projects ("
				+ "category_id, "
				+ "title, "
				+ "brief_description, "
				+ "full_description, "
				+ "video_link, "
				+ "required_sum, "
				+ "collected_sum, "
				+ "days_left)"
				+ "VALUES ('" 
				+ project.getCategoryID() + "', '" 
				+ project.getTitle() + "', '" 
				+ project.getBriefDescription() + "', '" 
				+ project.getFullDescription() + "', '"
				+ project.getVideoLink() + "', '"
				+ project.getRequiredSum() + "', '" 
				+ project.getCollectedSum() + "', '"
				+ project.getDaysLeft() + "')";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate(insertPrject);

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
				System.out.println("Problems with closing connection...");
			}
		}
		
	}

	@Override
	public List<Project> getAll() {
		String selectProjectsFilds = "SELECT id, category_id, title, brief_description, full_description, "
				+ "video_link, required_sum, collected_sum, days_left FROM projects";
		List<Project> projects = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectProjectsFilds);
			
			 while (resultSet.next()) {
			        int uniqueID = resultSet.getInt("id");
			        int categoryID = resultSet.getInt("category_id");
			        String title = resultSet.getString("title");
			        String briefDescription = resultSet.getString("brief_description");
			        String fullDescription = resultSet.getString("full_description");
			        String videoLink = resultSet.getString("video_link");
			        int requiredSum = resultSet.getInt("required_sum");
			        int collectedSum = resultSet.getInt("collected_sum");
			        int daysLeft = resultSet.getInt("days_left");
			      			 
			        Project project = new Project(title, briefDescription, requiredSum);
			        project.setUniqueID(uniqueID);
			        project.setCategoryID(categoryID);
			        project.setFullDescription(fullDescription);
			        project.setVideoLink(videoLink);
			        project.setCollectedSum(collectedSum);
			        project.setDaysLeft(daysLeft);
			       
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
				System.out.println("Problems with closing connection...");
			}
		}
		return projects;
	}

	@Override
	public int getSize() {
		String selectCountProjects = "SELECT count(*) from projects";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		int amountOfProjects = 0;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectCountProjects);

			while (resultSet.next()) {
				amountOfProjects = resultSet.getInt(1);
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
				System.out.println("Problems with closing connection...");
			}
		}
		return amountOfProjects;
	}

	@Override
	public List<Project> getProjectsFromCategory(Category category) {
		String selectProjectsFilds = "SELECT id, category_id, title, brief_description, full_description, "
				+ "video_link, required_sum, collected_sum, days_left FROM projects WHERE category_id = " 
				+ category.getUniqueID();
		
		List<Project> projectFromCategory = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectProjectsFilds);
			
			 while (resultSet.next()) {
			        int uniqueID = resultSet.getInt("id");
			        int categoryID = resultSet.getInt("category_id");
			        String title = resultSet.getString("title");
			        String briefDescription = resultSet.getString("brief_description");
			        String fullDescription = resultSet.getString("full_description");
			        String videoLink = resultSet.getString("video_link");
			        int requiredSum = resultSet.getInt("required_sum");
			        int collectedSum = resultSet.getInt("collected_sum");
			        int daysLeft = resultSet.getInt("days_left");
			      			 
			        Project project = new Project(title, briefDescription, requiredSum);
			        project.setUniqueID(uniqueID);
			        project.setCategoryID(categoryID);
			        project.setFullDescription(fullDescription);
			        project.setVideoLink(videoLink);
			        project.setCollectedSum(collectedSum);
			        project.setDaysLeft(daysLeft);
			       
			        projectFromCategory.add(project);
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
				System.out.println("Problems with closing connection...");
			}
		}
		return projectFromCategory;
	}
	
	@Override
	public void remove(Project project) {
		// TODO Auto-generated method stub
	}

}
