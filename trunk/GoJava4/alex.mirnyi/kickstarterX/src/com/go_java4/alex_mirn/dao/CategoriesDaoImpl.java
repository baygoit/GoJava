package com.go_java4.alex_mirn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;

public class CategoriesDaoImpl implements CategoriesDao{
	private ConnectionPool connectionPool;
	
	public CategoriesDaoImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void add(Category category) throws SQLException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<Category> getAll() throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select category_id, category_name from category");
		String sql = sqlBuilder.toString();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);
		ResultSet resultQuery = statement.executeQuery();
		while (resultQuery.next()) {
			int id = resultQuery.getInt("category_id");
			String  name = resultQuery.getString("category_name");
			categories.add(new Category(id, name));
		}
		return categories;
		
	}
	
	@Override
	public Category getCategoriesIndex(int index) throws SQLException {
		StringBuilder sql1 = new StringBuilder();
		sql1.append("select category_id, category_name from category where category_id = ?");
		String sql = sql1.toString();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);
		statement.setInt(1, index);
		ResultSet resultQuery = statement.executeQuery();
		if (resultQuery.next()) {
			int id = resultQuery.getInt("category_id");
			String  name = resultQuery.getString("category_name");
			return new Category(id, name);
		} else {
			throw new RuntimeException("Can not get category having index...");
		}

	}
	
	private String getSizeQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(category_id) from category");
		return sql.toString();
	}

	@Override
	public int getCategoriesSize() throws SQLException {
		String sql = getSizeQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		ResultSet resultQuery = statement.executeQuery();

		if (resultQuery.next()) {
			return getSizeFromResultQuery(resultQuery);
		} else {
			throw new RuntimeException("Can not get size of category");
		}
	}

	private int getSizeFromResultQuery(ResultSet resultQuery) throws SQLException {
		return resultQuery.getInt("count");
	}
}
