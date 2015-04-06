package com.gojava2.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;

import org.springframework.stereotype.Component;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorage;

@Component
public class CategoriesDAO extends AbstractDAO implements CategoryStorage {
	
	@Override
	public int getSize() {
		int result = 0;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM categories");
			while (resultSet.next()) {
				result = resultSet.getInt("count");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		} 
		return result;
	}

	@Override
	public void addCategory(Category category) {
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO categories (id, name) VALUES (?, ?)")) {
			statement.setInt(1, category.getId());
			statement.setString(2, category.getName());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Can't add new category", e);
		}
	}

	@Override
	public Category getCategory(int i) {
		Category result = null;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM categories WHERE id = " + i);
			while (resultSet.next()) {
				result = new Category(resultSet.getInt("id"), resultSet.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		}
		return result;
	}

	@Override
	public LinkedHashSet<Category> getCategories() {
		LinkedHashSet<Category> result = null;
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			result = new LinkedHashSet<Category>();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
			while (resultSet.next()) {
				result.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Somthing wrong with connection or statement", e);
		}
		return result;
	}
}