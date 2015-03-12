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
			String query = "UPDATE projects SET recieved=?"
					+ "WHERE id=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, project.getCollected());
			stmt.setInt(2, project.getId());
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProject(int id) {
		try (Connection connection = getConnection()){
			String query = "DELETE FROM projects WHERE id=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getLength() {
		int count=0;
		try (Connection connection = getConnection()){			 
			String query = "SELECT * FROM projects";
			
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
}