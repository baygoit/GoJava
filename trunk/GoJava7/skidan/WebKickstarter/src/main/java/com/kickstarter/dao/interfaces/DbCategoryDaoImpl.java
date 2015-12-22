package com.kickstarter.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kickstarter.model.Category;

@Repository
public class DbCategoryDaoImpl implements CategoryDaoInterface {

	// @Autowired
	// private BasicDataSource dbCon;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// public void setDbCon(BasicDataSource dbCon) {
	// this.dbCon = dbCon;
	// }

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
