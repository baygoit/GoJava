package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Category;

@Component
public class CategoryDbDao extends DbDao<Category> {

	private static final String TABLE = "category";
	private static final String FIELDS = "id, name";

	public CategoryDbDao() {	
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public CategoryDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	@Override
	protected Category readElement(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setId(resultSet.getInt("id"));
		category.setName(resultSet.getString("name"));
		return category;
	}
}
