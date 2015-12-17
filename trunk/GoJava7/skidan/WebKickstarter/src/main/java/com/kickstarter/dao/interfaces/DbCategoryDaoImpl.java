package com.kickstarter.dao.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kickstarter.model.Category;

@Component
public class DbCategoryDaoImpl implements CategoryDaoInterface {

	@Autowired
	private BasicDataSource dbCon;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public BasicDataSource getDbCon() {
		return dbCon;
	}

	public void setDbCon(BasicDataSource dbCon) {
		this.dbCon = dbCon;
	}

	public List<Category> getAll() {
		String sql = "select categoryId,categoryTitle from categories";
		return jdbcTemplate.query(sql, new CategoryMapper());

	}

	public Category getByNumber(int categoryNumber) {
		String sql = "select categoryId,categoryTitle from categories where categoryId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { categoryNumber }, new CategoryMapper());

	}

	public final class CategoryMapper implements RowMapper<Category> {

		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getInt("categoryId"));
			category.setTitle(rs.getString("categoryTitle"));
			return category;
		}

	}

}

//
// public List<Category> getAll() {
//
// ResultSet rs = null;
// List<Category> list = new ArrayList<>();
//
// try (PreparedStatement pStatement =
// dbCon.getConnection().prepareStatement("select * from categories")) {
// rs = pStatement.executeQuery();
// while (rs.next()) {
// Category category = new Category();
// category.setId(rs.getInt("categoryId"));
// category.setTitle(rs.getString("categoryTitle"));
// list.add(category);
// }
// } catch (SQLException e) {
// System.out.println("Category getAll MySql connection problem");
// }
// return list;
// }

// public Category getByNumber(int categoryNumber) {
// ResultSet rs = null;
// Category category = new Category();
//
// try (PreparedStatement pStatement = dbCon.getConnection()
// .prepareStatement("select * from categories where categoryId = ?")) {
// pStatement.setInt(1, categoryNumber);
// rs = pStatement.executeQuery();
// while (rs.next()) {
// category.setId(rs.getInt("categoryId"));
// category.setTitle(rs.getString("categoryTitle"));
// }
// } catch (SQLException e) {
// System.out.println("Category getCategorieByNumber MySql connection
// problem");
// }
// return category;
// }
