package kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.Category;

public interface iCategoryService {

	List<Category> getAll();

	void createCategories(iDAO interfaceDAO, Connection connection)
			throws SQLException;

}
