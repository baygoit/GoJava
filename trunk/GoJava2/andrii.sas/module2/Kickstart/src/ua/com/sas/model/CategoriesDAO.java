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
	public void addCategory(Category category) {
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.execute("insert into categories (name) values (\'" + category.getName() + "\')");
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}
	@Override
	public List<Category> getCategories() {
		try {
			List<Category> categories = new ArrayList<Category>();
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
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
	public Category readCategory(int index) {
		try {
			Category category = null;
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("select * from categories");
			int i = 0;
			while (rs.next()) {
				if (index == i){
					category = new Category(rs.getInt("id"), rs.getString("name"));
				}
				i++;
			}
			return category;
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public int getLenth() {
		try {
			int size = 0;
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
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
