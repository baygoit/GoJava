package kickstarter.model.dao;

import java.sql.SQLException;
import java.util.List;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.engine.Category;

public interface CategoriesDAO {
	void addCategory(String name) throws SQLException;

	List<Category> getCategories() throws SQLException;

	Category getCategory(int id) throws NoSuchDataException, SQLException;

	void createTableCategories() throws SQLException;
}
