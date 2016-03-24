package com.anmertrix.dao.sql;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anmertrix.Category;
import com.anmertrix.ConnectionManager;
import com.anmertrix.Project;
import com.anmertrix.dao.CategoryDao;

public class CategoryDaoSql implements CategoryDao {

	private ConnectionManager connectionManager;
	protected List<Category> categories = new ArrayList<Category>();

	public CategoryDaoSql(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public Category getCategory(int index) {
		
		Category category = new Category();
    	
		try {
			Statement statement = connectionManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT name FROM category WHERE id=" + index);
			rs.next();
			String name = rs.getString("name");
			category.setName(name);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return category;
	}
	
	@Override
	public List<Category> getCategories() {
		
		List<Category> categories = new ArrayList<Category>();
    	
		try {
			Statement statement = connectionManager.getConnection().createStatement();
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

	@Override
	public List<Project> getProjectsByCategoryId(int index) {
		
		List<Project> projects = new ArrayList<Project>();
    	
		try {
			Statement statement = connectionManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT name, description, required_budget, gathered_budget, days_left, history, url FROM project WHERE category_id=" + index);
			while(rs.next()) {
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
				
				projects.add(project);				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return projects;
	}
}
