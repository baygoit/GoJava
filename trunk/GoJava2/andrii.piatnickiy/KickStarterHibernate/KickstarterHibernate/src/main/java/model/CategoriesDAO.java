package model;

import java.sql.*;
import java.util.LinkedList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CategoriesDAO {
	

	@Autowired
	public DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private LinkedList<Category> categories = new LinkedList<Category>();
	private ResultSet resultSet;
	private Connection connection;
	
	private ResultSet getResultSet(String sql) {
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			new RuntimeException("SQLException " + e);
		}
		return resultSet;
	}

	public LinkedList<Category> getCategoriesList() {
		ResultSet resultSet = getResultSet("SELECT * FROM categories");
		try {
			while (resultSet.next()) {
				categories.add(new Category(resultSet.getInt("category_id"),
						resultSet.getString("name")));
			}
			return categories;
		} catch (SQLException e) {
			new RuntimeException("SQLException " + e);
		}
		return categories;
	}

}
