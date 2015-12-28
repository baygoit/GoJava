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

		String sql = "SELECT c.id, c.name "
				+ "FROM category c "				
				+ "LEFT JOIN project ON c.id = project.categoryId "
				+ "LEFT JOIN payment ON project.id = payment.projectId " 
				+ "GROUP BY c.id, c.name "
				+ "ORDER BY SUM(CASE WHEN payment.pledge IS NULL THEN 0 ELSE payment.pledge END) DESC limit 10";
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

	@Override
	public Category getBestCategory() {
		
		String sql = "SELECT c.id, c.name FROM category c "
				+ "WHERE c.id = ("
				+ "SELECT p.categoryId FROM project p "
				+ "JOIN payment ON p.id = payment.projectId "
				+ "GROUP BY p.categoryId, p.id, p.name "
				+ "HAVING SUM(payment.pledge) = ( SELECT MAX(t.pledge) "
				+ "FROM (SELECT projectId, SUM(pledge) pledge FROM payment GROUP BY projectId) t))";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}

}
