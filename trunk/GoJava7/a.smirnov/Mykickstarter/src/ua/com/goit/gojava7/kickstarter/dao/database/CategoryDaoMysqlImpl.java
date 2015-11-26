package ua.com.goit.gojava7.kickstarter.dao.database;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.AbstractCategoryDao;

public class CategoryDaoMysqlImpl extends AbstractCategoryDao {
	private static final String INSERT_CATEGORY = "INSERT INTO categories (name) VALUES (?)";
	private static final String DELETE_CATEGORY = "DELETE FROM categories WHERE id = ?";
	private static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM catigories";
	private static final String COUNT_ALL_CATEGORIES = "SELECT count(*) FROM categories";
	
	@Override
	public void add(Category category) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY)) {		
		
			statement.setString(2, category.getName());
			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void remove(Category category) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY)){		
		
			statement.setInt(1, category.getUniqueID());
			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIES)) {
				
			while (resultSet.next()) {
				int categoryID = resultSet.getInt("id");
			    String categoryName = resultSet.getString("name");
			    
			    Category category = new Category();
			    category.setName(categoryName);
			    category.setUniqueID(categoryID);
			    
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
		
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(COUNT_ALL_CATEGORIES)) {

			while (resultSet.next()) {
				amountOfCatrgories = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return amountOfCatrgories;
	}
}
