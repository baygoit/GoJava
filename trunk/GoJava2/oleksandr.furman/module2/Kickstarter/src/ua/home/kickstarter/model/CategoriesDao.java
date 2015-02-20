package ua.home.kickstarter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.home.kickstarter.content.Category;

public class CategoriesDao {
	private final Connection connection;

	public List<Category> getAll() throws SQLException {
		String sql = "SELECT * FROM categories";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			list.add(category);
		}
		return list;
	}

	public long size() throws SQLException {
		long count = 0;
		String sql = "SELECT COUNT(*) AS count FROM categories";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			count = rs.getLong("count");
		}
		return count;
	}

	public CategoriesDao(Connection connection) {
		this.connection = connection;
	}
}
