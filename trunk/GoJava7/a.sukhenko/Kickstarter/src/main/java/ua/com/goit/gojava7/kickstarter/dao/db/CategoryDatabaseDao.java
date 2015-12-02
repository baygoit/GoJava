package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryDatabaseDao extends DatabaseDao<Category> implements CategoryStorage{

	private static String	TABLE	= "category";
	private static String	FIELDS	= "name";

	public CategoryDatabaseDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	protected Category readElement(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setCategoryName(resultSet.getString("name"));
		return category;
	}

	@Override
	public Category getCategoryById(int projectCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
