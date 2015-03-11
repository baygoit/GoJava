package com.goit.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.goit.kickstarter.model.Project;

@Component
public class ProjectDAO extends AbstractDAO{	
		
	public Project getProject(int id) {
		Project proj = null;
		try (Connection connection = getConnection()){
			String query = "SELECT * FROM projects WHERE id ="+id;
			
			PreparedStatement stmt = connection.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				proj = new Project(rs.getInt("id"), rs.getString("project_name"), 
						rs.getString("description"), rs.getString("story"), rs.getString("link"), 
						rs.getInt("value"), rs.getInt("recieved"), rs.getInt("days"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proj;
	}
	
	public Project getProject(String project) {
		Project proj = null;
		try (Connection connection = getConnection()){
			String query = "SELECT * FROM projects WHERE project_name =?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, project);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				proj = new Project(rs.getInt("id"), rs.getString("project_name"), 
					rs.getString("description"), rs.getString("story"), rs.getString("link"), 
					rs.getInt("value"), rs.getInt("recieved"), rs.getInt("days"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proj;
	}

	public void createProject(Project project) {
		try (Connection connection = getConnection()){
			String query = "INSERT into projects(project_name, value, description)"
					+"VALUES(?, ?, ?);";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, project.getTitle());
			stmt.setInt(2, project.getProjectPrice());
			stmt.setString(3, project.getDescription());
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProject(Project project) {
		try (Connection connection = getConnection()){
			String query = "UPDATE projects SET value=?, description=? "
					+ "WHERE project_name=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, project.getProjectPrice());
			stmt.setString(2, project.getDescription());
			stmt.setString(3, project.getTitle());
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProject(String title) {
		try (Connection connection = getConnection()){
			String query = "DELETE FROM projects WHERE project_name=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, title);
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getLength(String condition) {
		int count=0;
		try (Connection connection = getConnection()){			 
			String query = "SELECT * FROM projects "+condition;
			
			PreparedStatement stmt = connection.prepareStatement(query);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return count;
	}
	
	public int getLength(int id) {
		int count=0;
		try (Connection connection = getConnection()){			 
			String query = "SELECT * FROM projects WHERE category="+id;
			
			PreparedStatement stmt = connection.prepareStatement(query);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return count;
	}
	
	public List<Project> getProjects(int categoryId) {
		List<Project> list = new ArrayList<Project>();
		try (Connection connection = getConnection()){			 
			String query = "SELECT * FROM projects WHERE category = ?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, categoryId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				list.add(new Project(rs.getInt("id"), rs.getString("project_name"), 
						rs.getString("description"), rs.getString("story"), rs.getString("link"), 
						rs.getInt("value"), rs.getInt("recieved"), rs.getInt("days")));
			}
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return list;
	}
}