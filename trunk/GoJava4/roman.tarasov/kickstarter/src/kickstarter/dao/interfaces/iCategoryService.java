package kickstarter.dao.interfaces;


import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.Category;

public interface iCategoryService {

	List<Category> getAll();

	void createCategories(iDAO interfaceDAO)
			throws SQLException;

}
