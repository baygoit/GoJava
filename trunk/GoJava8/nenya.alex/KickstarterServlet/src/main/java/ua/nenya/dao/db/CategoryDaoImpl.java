package ua.nenya.dao.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static final String GET_ALL_CATEGORIES = "SELECT name, id FROM categories ORDER BY name";

	private static final String GET_COUNT_CATEGORY_BY_NAME = "SELECT COUNT(name) FROM Categories WHERE name = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Category> getCategories() {
		return jdbcTemplate.query(GET_ALL_CATEGORIES, new BeanPropertyRowMapper<Category>(Category.class));
	}

	@Override
	public boolean isCategoryExist(String categoryName) {
		return jdbcTemplate.queryForObject(GET_COUNT_CATEGORY_BY_NAME, new Object[] { categoryName }, Integer.class) == 1;
	}

}
