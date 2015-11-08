package ua.com.sas.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO implements Categories {

	private Connection connection;
	
	public CategoriesDAO(ConnectionDAO connectionDAO) {
		connection = connectionDAO.getConnection();
	}
	
	@Override
	public void add(Category category) {
		try {
			Statement statement = connection.createStatement();
			statement.execute("INSERT INTO categories (name) VALUES (\'" + category.getName() + "\')");
			ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE name = \'" + category.getName() + "\'");
			while (rs.next()){
				category.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public List<Category> getCategories() {
		try {
			List<Category> categories = new ArrayList<Category>();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM categories");
			while (rs.next()){
				categories.add(new Category(rs.getInt(1), rs.getString(2)));
			}
			return categories;
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}
	
	@Override
	public Category get(int id) {
		try {
			Category category = null;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE id = " + id);
			while (rs.next()) {
				category = new Category(rs.getInt(1), rs.getString(2));
			}
			return category;
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public int size() {
		try {
			int size = 0;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) from categories");
			while (rs.next()) {
				size = rs.getInt(1);
			}
			return size;
		} catch (SQLException e) {
			throw new RuntimeException(
					"Connection Failed! Check output console", e);
		}
	}

}
