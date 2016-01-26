package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;


public class CategoryDbStorage extends AbstractCategoryStorage {

	private final String INSERT_CATEGORY = "INSERT INTO categories (name) VALUES (?)";
	private final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM categories";
	private final String SELECT_CATEGORY = "SELECT id, name FROM categories WHERE id = ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Category> getAll() {
		return jdbcTemplate.query(SELECT_ALL_CATEGORIES, new Mapper());
	}

	@Override
	public void add(Category category) {
		jdbcTemplate.batchUpdate(INSERT_CATEGORY, new StatementSetter(category));
	}

	@Override
	public Category getCategoryById(int idOfCategory) {
		return jdbcTemplate.queryForObject(SELECT_CATEGORY + idOfCategory, new Mapper());
	}
	
	public class Mapper implements RowMapper<Category> {
		
		@Override
		public Category mapRow(ResultSet resultSet, int index) throws SQLException {
			
			Category category = new Category();
			category.setIdCategory(resultSet.getInt("id"));
			category.setCategoryName(resultSet.getString("name"));
			return category;
		}
	}
	
	public class StatementSetter implements BatchPreparedStatementSetter {
		
		List<Category> categories;
		
		public StatementSetter(Category category) {
			categories = new ArrayList<>();
			categories.add(category);
		}
		
		@Override
		public int getBatchSize() {
			return categories.size();
		}

		@Override
		public void setValues(PreparedStatement statement, int index) throws SQLException {
			Category category = categories.get(index);
			statement.setString(1, category.getCategoryName());
		}

	}

}
