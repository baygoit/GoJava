package model;

import java.sql.*;
import java.util.LinkedList;


public class CategoriesDAO {
	private LinkedList<Category> categories = new LinkedList<Category>();
	private Connection connection;

	public CategoriesDAO(Connection connection) {
		this.connection = connection;
	}

	private ResultSet getResultSet(String sql) {
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			new RuntimeException("SQLException " + e);
		}
		return resultSet;
	}

	public LinkedList<Category> getCategoriesList() {
		ResultSet resultSet = getResultSet("select * from categories");
		try {
			while (resultSet.next()) {
				categories.add(new Category(resultSet.getInt("category_id"), resultSet.getString("name")));
			}
			return categories;
		} catch (SQLException e) {
			new RuntimeException("SQLException " + e);
		}
		return categories;
	}

}
