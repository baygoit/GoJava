package ua.com.goit.gojava7.kickstarter.storage_in_database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;

public class CategoriesStorage implements CategoryDAO {
	private static final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
	@Override
	public void add(Category category) {
		String insertCategory = "INSERT INTO categories (name) VALUES ('" + category.getCategoryName() + "')";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate(insertCategory);

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
	public List<Category> getAll() {
		String SelectCategoryFilds = "SELECT id, name from categories";
		List<Category> categories = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SelectCategoryFilds);
			
			 while (resultSet.next()) {
			        int categoryID = resultSet.getInt("id");
			        String categoryName = resultSet.getString("name");
			 
			        Category category = new Category(categoryName);
			        category.setUniqueID(categoryID);
			        categories.add(category);
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
		return categories;
	}

	@Override
	public int getSize() {
		String selectCountCategories = "SELECT count(*) from categories";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		int amountOfCatrgories = 0;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectCountCategories);

			while (resultSet.next()) {
				amountOfCatrgories = resultSet.getInt(1);
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
		return amountOfCatrgories;
	}

	@Override
	public void remove(Category category) {
		// TODO Auto-generated method stub
	}
}
