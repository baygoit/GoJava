package com.gojava2.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorage;

public class CategoriesDAO implements CategoryStorage {
	
	private Connection connection;
	
	public CategoriesDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int getSize() {
		int result = 0;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS COUNT FROM categories");
			while (resultSet.next()) {
				result = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return result;
	}

	@Override
	public void addCategory(Category category) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("INSERT INTO categories (id, name) VALUES (?, ?)");
			statement.setInt(1, category.getId());
			statement.setString(2, category.getName());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Can't add new quote", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
	}

	@Override
	public Category getCategory(int i) {
		Statement statement = null;
		Category result = null;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM categories WHERE id = " + i);
			while (resultSet.next()) {
				result = new Category(resultSet.getInt("id"), resultSet.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return result;
	}

	@Override
	public LinkedHashSet<Category> getCategories() {
		Statement statement = null;
		LinkedHashSet<Category> result = null;
		try {
			statement = connection.createStatement();
			result = new LinkedHashSet<Category>();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
			while (resultSet.next()) {
				result.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return result;
	}
}