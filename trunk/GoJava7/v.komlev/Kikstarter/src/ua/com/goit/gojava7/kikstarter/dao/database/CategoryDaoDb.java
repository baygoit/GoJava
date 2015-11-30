package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;

public class CategoryDaoDb implements CategoryDao {

	private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:PROBA";
	private static final String USER_NAME = "MILLER";
	private static final String PASSWORD = "KOLOBOK";
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	@Override
	public void add(Category category) {
		String insertCategory = "INSERT INTO categories(id, name) VALUES('"
				+ category.getUniqueID() + "', '" + category.getName() + "')";

		connection = null;
		statement = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate(insertCategory);
		} catch (Exception e) {
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
				System.out.println("You have a problem with connection DB!");
			}
		}

	}

	@Override
	public void remove(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> getAll() {
		String selectFieldsOfCategoties = "SELECT id, name FROM categories ORDER BY id";
		List<Category> categories = new ArrayList<>();

		connection = null;
		statement = null;
		resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectFieldsOfCategoties);

			while (resultSet.next()) {
				int id = Integer.parseInt(resultSet.getString("id"));
				String name = resultSet.getString("name");

				categories.add(new Category(id, name));
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
				System.out.println("You have a problem with connection DB!");
			}
		}

		return categories;
	}

	@Override
	public int getSize() {
		return getAll().size();
	}

}
