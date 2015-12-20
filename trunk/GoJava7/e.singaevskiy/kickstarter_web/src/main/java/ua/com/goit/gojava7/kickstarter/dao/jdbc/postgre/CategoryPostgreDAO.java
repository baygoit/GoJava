package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryPostgreDAO implements CategoryDAO {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void clear() {
		String sql = "delete from category";
		jdbcTemplate.execute(sql);
	}

	@Override
	public Category get(int index) {
		String sql = "select id, name from category where id = " + index;
		return jdbcTemplate.queryForObject(sql, new ElementMapper());
	}

	@Override
	public void add(Category element) {
		String sql = "insert into category (id, name) values (?, ?)";
		jdbcTemplate.batchUpdate(sql, new StatementSetter(element));
	}

	@Override
	public void addAll(List<Category> elements) {
		String sql = "insert into category (id, name) values (?, ?)";
		jdbcTemplate.batchUpdate(sql, new StatementSetter(elements));
	}

	@Override
	public List<Category> getAll() {
		String sql = "select id, name from category";
		return jdbcTemplate.query(sql, new ElementMapper());
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final class StatementSetter implements BatchPreparedStatementSetter {

		List<Category> list;

		StatementSetter(List<Category> list) {
			this.list = list;
		}

		StatementSetter(Category element) {
			list = new ArrayList<>();
			list.add(element);
		}

		@Override
		public void setValues(PreparedStatement statement, int i) throws SQLException {
			Category element = list.get(i);
			statement.setObject(1, element.getId());
			statement.setObject(2, element.getName());
		}

		@Override
		public int getBatchSize() {
			return list.size();
		}
	}

	private final class ElementMapper implements RowMapper<Category> {

		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			return category;
		}

	}
}
