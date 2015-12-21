package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.AbstractJdbcTemplate;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;

@Repository
public class CategoryDaoMysqlImpl extends AbstractJdbcTemplate implements CategoryDao {

	public void add(Category category) {
		String sql = "INSERT INTO categories (name) VALUES (?)";
		getJdbcTemplate().update(sql, new Object[] { category.getName() });
	}

	public void remove(Category category) {
		String sql = "DELETE FROM categories WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] { category.getUniqueID() });
	}

	public List<Category> getAll() {
		String sql = "SELECT id, name FROM categories";
		return getJdbcTemplate().query(sql, new CategoryRowMapper());
	}

	public Category getCategoryById(int id) {
		String sql = "SELECT id, name FROM categories WHERE id = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[] { id }, new CategoryRowMapper());
	}

	public class CategoryRowMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setUniqueID(rs.getInt("id"));
			category.setName(rs.getString("name"));
			return category;
		}
	}
}
