package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kikstarter.config.ConnectionPoolSource;
import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;

public class CategoryDaoDbImpl implements CategoryDao {

	private static final String INSERT_CATEGORY = "INSERT INTO categories (id, name) VALUES(?, ?)";
	private static final String DELETE_CATEGORY = "DELETE FROM categories WHERE id = ?";
	private static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM categories ORDER BY id";
	private static final String SELECT_ID_CATEGORY = "SELECT id, name FROM categories WHERE id = ?";
	private static final String SELECT_COUNT_CATEGORIES = "SELECT COUNT(name) FROM categories";
	
	ConnectionPoolSource dataSource;

	public CategoryDaoDbImpl(ConnectionPoolSource datasource) {
		this.dataSource = datasource;
	}

	@Override
	public void add(Category category) {

		try {
			Connection connection = dataSource.getConnection();
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
			Connection connection = dataSource.getConnection();
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
			Connection connection = dataSource.getConnection();
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
			Connection connection = dataSource.getConnection();
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
			Connection connection = dataSource.getConnection();
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
