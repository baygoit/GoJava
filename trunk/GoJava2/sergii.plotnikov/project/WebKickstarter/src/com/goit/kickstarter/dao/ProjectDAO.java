package com.goit.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goit.kickstarter.model.Category;
import com.goit.kickstarter.model.Project;

public class ProjectDAO {	
	private String user = "postgres";
	private String password = "123";
	private String url = "jdbc:postgresql://localhost:5433/kickstarterdb";
	private String driver = "org.postgresql.Driver";
	
	private Connection connection;

	public ProjectDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Project getProject(int id) {
		Project proj = null;
		try {
			String query = "SELECT * FROM projects WHERE id ="+id;
			
			PreparedStatement stmt = connection.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				proj = new Project(rs.getInt("id"), rs.getString("project_name"), 
						rs.getString("description"), rs.getString("story"), rs.getString("link"), 
						rs.getInt("value"), rs.getInt("recieved"), rs.getInt("days"));
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proj;
	}
	
	public Project getProject(String project) {
		Project proj = null;
		try {
			String query = "SELECT * FROM projects WHERE project_name =?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, project);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				proj = new Project(rs.getInt("id"), rs.getString("project_name"), 
					rs.getString("description"), rs.getString("story"), rs.getString("link"), 
					rs.getInt("value"), rs.getInt("recieved"), rs.getInt("days"));
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proj;
	}

	public void createProject(Project project) {
		try {
			String query = "INSERT into projects(project_name, value, description)"
					+"VALUES(?, ?, ?);";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, project.getTitle());
			stmt.setInt(2, project.getProjectPrice());
			stmt.setString(3, project.getDescription());
			
			stmt.executeUpdate();	
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProject(Project project) {
		try {
			String query = "UPDATE projects SET value=?, description=? "
					+ "WHERE project_name=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, project.getProjectPrice());
			stmt.setString(2, project.getDescription());
			stmt.setString(3, project.getTitle());
			
			stmt.executeUpdate();	
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProject(String title) {
		try {
			String query = "DELETE FROM projects WHERE project_name=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, title);
			
			stmt.executeUpdate();	
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password); 
	} 
	
	public ProjectDAO(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	public int getLength(String condition) {
		int count=0;
		try {			 
			String query = "SELECT * FROM projects "+condition;
			
			PreparedStatement stmt = connection.prepareStatement(query);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count++;
			}
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return count;
	}
	
	public int getLength(int id) {
		int count=0;
		try {			 
			String query = "SELECT * FROM projects WHERE category="+id;
			
			PreparedStatement stmt = connection.prepareStatement(query);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count++;
			}
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return count;
	}
	
	public List<Project> getProjects(Category category) {
		List<Project> list = new ArrayList<Project>();
		try {			 
			String query = "SELECT * FROM projects WHERE category = " + category.getId();
			
			PreparedStatement stmt = connection.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				list.add(new Project(rs.getInt("id"), rs.getString("project_name"), 
						rs.getString("description"), rs.getString("story"), rs.getString("link"), 
						rs.getInt("value"), rs.getInt("recieved"), rs.getInt("days")));
			}
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return list;
	}
}