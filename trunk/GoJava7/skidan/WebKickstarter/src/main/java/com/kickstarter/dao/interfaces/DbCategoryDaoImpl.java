package com.kickstarter.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kickstarter.model.Category;

@Component
public class DbCategoryDaoImpl implements CategoryDaoInterface {
	
	private static final Logger log = LoggerFactory.getLogger(DbCategoryDaoImpl.class);

//	@Autowired
//	private BasicDataSource dbCon;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	public void setDbCon(BasicDataSource dbCon) {
//		this.dbCon = dbCon;
//	}

	public List<Category> getAll() {
		log.info("CategoryDao getAll Called");
		String sql = "select categoryId,categoryTitle from categories";
		return jdbcTemplate.query(sql, new CategoryMapper());

	}

	public Category getByNumber(int categoryNumber) {
		log.info("CategoryDao getByNumber was called with arg : " + categoryNumber);
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

