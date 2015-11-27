package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryDbDao extends DbDao<Category> implements CategoryStorage {

	private static String TABLE = "category";
	private static String FIELDS = "name";

	public CategoryDbDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	public int size() {
		int size = 0;
		String query = "select count(*) from category";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				size = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

	@Override
	protected Category readElement(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setName(resultSet.getString("name"));
		return category;
	}
}
