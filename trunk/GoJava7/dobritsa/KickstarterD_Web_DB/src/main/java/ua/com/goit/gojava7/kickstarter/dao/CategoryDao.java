package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Category;

@Repository
public class CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

	public CategoryDao() {
		log.info("Constructor CategoryDao()...");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Category> getAll() {
		log.info("<Category> getAll()...");
		String query = "select id, name from category";
		return jdbcTemplate.query(query, new CategoryMapper());
	}

	public Category get(int index) {
		log.info("<Category> get({})...", index);
		String query = "select id, name from category where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { index }, new CategoryMapper());
	}

	private final class CategoryMapper implements RowMapper<Category> {
		public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("CategoryMapper()...");
			Category category = new Category();
			category.setId(resultSet.getInt("id"));
			category.setName(resultSet.getString("name"));
			log.debug("CategoryMapper() returned category: {}", category);
			return category;
		}
	}
}
