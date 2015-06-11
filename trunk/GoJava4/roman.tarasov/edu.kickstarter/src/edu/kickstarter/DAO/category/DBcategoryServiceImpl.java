package edu.kickstarter.DAO.category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.kickstarter.database.DatabaseService;
import edu.kickstarter.entity.Category;

public class DBcategoryServiceImpl implements CategoryService {
	private List<Category> categories;

	@Override
	public List<Category> getAll() throws SQLException {
		categories = new ArrayList<Category>();
		
		Statement statement = DatabaseService.getInstance().getConnection().createStatement();
		ResultSet resultSet = statement
				.executeQuery("SELECT COUNT(*) AS rowcount FROM categories");
		resultSet.next();
		int count = resultSet.getInt("rowcount");
		resultSet = statement
				.executeQuery("SELECT id,category  FROM categories");
		for (int pointer = 0; pointer < count; pointer++) {
			resultSet.next();
			Category category = new Category();
			category.setID(resultSet.getInt("id"));
			category.setName(resultSet.getString("category"));
			categories.add(category);
		}
		return categories;
	}
}