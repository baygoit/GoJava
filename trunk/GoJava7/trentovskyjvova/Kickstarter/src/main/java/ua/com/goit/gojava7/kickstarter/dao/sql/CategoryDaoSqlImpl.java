package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Repository
public class CategoryDaoSqlImpl implements CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Category> getCategories() {

		String sql = "SELECT id, name FROM category";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}

	@Override
	public Category getCategory(int id) {

		String sql = "SELECT id, name FROM category WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { id },
				new BeanPropertyRowMapper<Category>(Category.class));
	}

	@Override
	public int size() {

		String sql = "SELECT COUNT(*) size FROM category";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
