package com.anmertrix.dao.sql;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;

public class CategoryDaoSql implements CategoryDao {

	private ConnectionManager connectionManager;

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
	
}
