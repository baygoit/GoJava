package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;

public class CategoryDaoMysqlImpl implements CategoryDao {
	
	private static final String INSERT_CATEGORY = "INSERT INTO categories (name) VALUES (?)";
	private static final String DELETE_CATEGORY = "DELETE FROM categories WHERE id = ?";
	private static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM categories";
	private static final String COUNT_ALL_CATEGORIES = "SELECT count(*) FROM categories";
	private static final String SELECT_CATEGORY_BY_ID = "SELECT id, name FROM categories WHERE id = ?";
	
	private Connection connection;
	private Category searchedCategory;
	
	public CategoryDaoMysqlImpl(Connection connection) {
		
		this.connection = connection;
		
	}	
	
	@Override
	public void add(Category category) {
		
		try (PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY)) {	
			
			statement.setString(1, category.getName());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	@Override
	public void remove(Category category) {
		
		try (PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY)){		
			
			statement.setInt(1, category.getUniqueID());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	@Override
	public List<Category> getAll() {
		
		List<Category> categories = new ArrayList<>();
		
		try (Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIES)) {
				
			while (resultSet.next()) {
				Category category = new Category();
				
				category.setUniqueID(resultSet.getInt("id"));
				
				category.setName(resultSet.getString("name"));
				
			    categories.add(category);
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} 
		
		return categories;
	}

	@Override
	public int getSize() {
		
		int amountOfCatrgories = 0;
		
		try (Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery(COUNT_ALL_CATEGORIES)) {

			while (resultSet.next()) {
				
				amountOfCatrgories = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} 
		
		return amountOfCatrgories;
		
	}
	
	@Override
	public Category getCategoryById(int id) {
		
		searchedCategory = null;
		
		try (PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {	
			
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
		
			while (resultSet.next()) {
				
				searchedCategory.setUniqueID(resultSet.getInt("id"));
				
				searchedCategory.setName(resultSet.getString("name"));
				
			 }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return searchedCategory;
		
	}
}
