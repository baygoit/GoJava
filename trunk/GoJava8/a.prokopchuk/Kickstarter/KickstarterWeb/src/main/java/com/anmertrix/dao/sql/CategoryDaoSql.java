package com.anmertrix.dao.sql;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public class CategoryDaoSql implements CategoryDao {

	private ConnectionManager connectionManager;
	protected List<Category> categories = new ArrayList<Category>();

	public CategoryDaoSql(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public Category getCategory(int index) {
		
		Category category = new Category();
    	
		try (Statement statement = connectionManager.getConnection().createStatement()) {
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
    	
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet rs = statement.executeQuery("SELECT id, name FROM category");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category category = new Category(name);
				category.setId(id);
				categories.add(category);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return categories;
	}

	@Override
	public List<Project> getProjectsByCategoryId(int index) {
		
		
    	
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			List<Project> projects = new ArrayList<Project>();
			ResultSet rs = statement.executeQuery("SELECT id, name FROM project WHERE category_id=" + index);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				Project project = new Project();
				project.setId(id);
				project.setName(name);
				projects.add(project);				
			}
			return projects;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		
	}
	
	@Override
	public Project getProjectById(int index) {
		
		Project project = new Project();
    	
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet rs = statement.executeQuery("SELECT name, description, required_budget, days_left, history, url, COALESCE(SUM(amount),0) AS sum_amount FROM project JOIN investment ON (project.id = investment.project_id) WHERE project_id=" + index);
			
			rs.next();
			String name = rs.getString("name");
			String description = rs.getString("description");
			int required_budget = rs.getInt("required_budget");
			int days_left = rs.getInt("days_left");
			String history = rs.getString("history");
			String url = rs.getString("url");
			int gathered_budget = rs.getInt("sum_amount");
				
			project.setProjectData(index, name, description, required_budget, gathered_budget, days_left, history);
			project.setUrl(url);
				
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return project;
	}
}
