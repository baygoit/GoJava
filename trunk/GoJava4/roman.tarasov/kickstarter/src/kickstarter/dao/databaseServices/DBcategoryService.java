package kickstarter.dao.databaseServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.interfaces.iCategoryService;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.entity.Category;

public class DBcategoryService implements iCategoryService {
	private List<Category> categories;
	private iDatabaseService dbService;

	public DBcategoryService(iDatabaseService dbService) {
		this.dbService = dbService;
	}

	@Override
	public List<Category> getAll() throws SQLException {
		categories = new ArrayList<Category>();
		Statement statement = dbService.getConnection().createStatement();
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

	@Override
	public void createCategories(iDAO sourceDAO) throws SQLException {
		List<Category> categories = sourceDAO.getCategoryService().getAll();
		Statement statement = dbService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  categories ");
		statement
				.executeUpdate("CREATE TABLE categories (id SERIAL not null PRIMARY KEY, category varchar(255))");
		for (Category category : categories) {
			statement.executeUpdate("INSERT INTO categories VALUES ("
					+ category.getID() + "," + "'" + category.getName() + "')");
		}
	}
}