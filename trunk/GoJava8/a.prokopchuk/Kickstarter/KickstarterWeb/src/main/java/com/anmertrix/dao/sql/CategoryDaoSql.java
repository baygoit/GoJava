package com.anmertrix.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;

@Repository
public class CategoryDaoSql implements CategoryDao {

	private static final String SELECT_CATEGORIES = "SELECT id, name FROM category";
	private static final String SELECT_CATEGORY_BY_ID = "SELECT id, name FROM category WHERE id=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final class CategoryRowMapper implements RowMapper<Category> {
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			return category;
		}
	}

	@Override
	public Category getCategory(int categoryId) {
		return jdbcTemplate.queryForObject(SELECT_CATEGORY_BY_ID, new Object[]{categoryId}, new CategoryRowMapper());
	}

	@Override
	public List<Category> getCategories() {
		return jdbcTemplate.query(SELECT_CATEGORIES, new BeanPropertyRowMapper<Category>(Category.class));
	}

}
