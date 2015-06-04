package kickstarter.dao.defaultServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.interfaces.iCategoryService;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.entity.Category;

public class DefaultCategoryService implements iCategoryService {
	List<Category> categories;

	public DefaultCategoryService() {
		categories = new ArrayList<Category>();
		Category category = new Category();
		category.setID(5);
		category.setName("Technology");
		categories.add(category);

		category = new Category();
		category.setID(4);
		category.setName("Social");
		categories.add(category);
	}

	@Override
	public List<Category> getAll() {
		return categories;
	}

	@Override
	public void createCategories(iDAO interfaceDAO)
			throws SQLException {
	
		
	}
}
