package com.anmertrix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anmertrix.dao.CategoryDao;

public class ManagementSystem {
	
	private static Connection connection;
    
    protected ManagementSystem() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://s14.thehost.com.ua/kickstarter";
            connection = DriverManager.getConnection(url, "kickstarter", "kickstarter");
        } catch (ClassNotFoundException e) {
           // no
        } catch (SQLException e) {
        	// no
        }
        
    }

    public synchronized ManagementSystem getInstance() throws Exception {
        return this;
    }
    
    public String getRandomQuote() {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT id, author, text FROM quote order by rand() limit 1");
			rs.next();
			String author = rs.getString("author");
			String text = rs.getString("text");
			return text + "(" + author + ")";
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
    
    public List<Category> getCategories() {
    	
    	List<Category> categories = new ArrayList<Category>();
    	
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT name FROM category");
			while(rs.next()) {
				String name = rs.getString("name");
				categories.add(new Category(name));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return categories;
	}
    
    public List<Project> getProjects(CategoryDao categoryDao) {
    	
    	List<Project> projects = new ArrayList<Project>();
    	
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT category_id, name, description, required_budget, gathered_budget, days_left, history, url FROM project");
			while(rs.next()) {
				int category_id = rs.getInt("category_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int required_budget = rs.getInt("required_budget");
				int gathered_budget = rs.getInt("gathered_budget");
				int days_left = rs.getInt("days_left");
				String history = rs.getString("history");
				String url = rs.getString("url");
				
				Project project = new Project();
				project.setProjectData(name, description, required_budget, gathered_budget, days_left, history);
				project.setURL(url);
				
				
				categoryDao.getCategories().get(category_id - 1).setProject(project);
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return projects;
	}
}
