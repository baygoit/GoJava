package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryDatabaseDao extends DatabaseDao<Category> implements CategoryStorage{

	private static String	TABLE	= "categories";
	private static String	FIELDS	= "categoryId,categoryName";

	public CategoryDatabaseDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	protected Category readElement(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setCategoryId(resultSet.getInt("categoryId"));
		category.setCategoryName(resultSet.getString("categoryName"));
		return category;
	}

	@Override
	public Category getCategoryById(int projectCategoryId) {
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE categoryId = " + projectCategoryId;
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("categoryId"));
				category.setCategoryName(resultSet.getString("categoryName"));
				return category;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new NoSuchElementException();
	}

	@Override
	public void add(Category element) {
		

	}
}
