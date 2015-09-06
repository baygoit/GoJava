package goit.nz.kickstarter.dao;

import goit.nz.kickstarter.domain.Category;
import goit.nz.kickstarter.storage.DataProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	private DataProvider storage;

	public CategoryDAO(DataProvider storage) {
		this.storage = storage;
	}

	public List<Category> getCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "SELECT id, name FROM categories";
		try (Connection conn = storage.getConnection()) {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String categoryName = resultSet.getString("name");
				int categoryId = resultSet.getInt("id");
				Category category = new Category(categoryId, categoryName);
				result.add(category);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Category getCategory(long categoryId) {
		Category found = null;
		String sql = "SELECT name FROM categories WHERE id = ?";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, categoryId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String categoryName = resultSet.getString("name");
				found = new Category(categoryId, categoryName);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}
}
