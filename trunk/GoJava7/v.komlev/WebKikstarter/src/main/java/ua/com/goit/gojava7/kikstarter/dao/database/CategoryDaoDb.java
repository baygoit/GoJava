package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;

public class CategoryDaoDb implements CategoryDao {

	private static final String INSERT_CATEGORY = "INSERT INTO categories (id, name) VALUES(?, ?)";
	private static final String DELETE_CATEGORY = "DELETE FROM categories WHERE id = ?";
	private static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM categories ORDER BY id";
	private static final String SELECT_ID_CATEGORY = "SELECT id, name FROM categories WHERE id = ?";
	private static final String SELECT_COUNT_CATEGORIES = "SELECT COUNT(name) FROM categories";
	Connection connection;

	public CategoryDaoDb(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void add(Category category) {

		try {
			PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY);
			statement.setInt(1, category.getUniqueID());
			statement.setString(2, category.getName());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Category category) {

		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY);
			statement.setInt(1, category.getUniqueID());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int uniqueID = resultSet.getInt(1);
				String name = resultSet.getString("name");

				categories.add(new Category(uniqueID, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public int getSize() {
		int countCategories = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_COUNT_CATEGORIES);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				countCategories = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return countCategories;
	}

	@Override
	public Category getCategory(int categoryId) {
		Category category = null;

		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_ID_CATEGORY);
			statement.setInt(1, categoryId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int uniqueID = resultSet.getInt(1);
				String name = resultSet.getString("name");

				category = new Category(uniqueID, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return category;
	}

}
