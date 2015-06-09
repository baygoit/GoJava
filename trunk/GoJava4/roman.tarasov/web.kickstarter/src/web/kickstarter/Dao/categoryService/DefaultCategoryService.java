package web.kickstarter.Dao.categoryService;

import java.util.ArrayList;
import java.util.List;

import web.kickstarter.databaseDao.DatabaseService;
import web.kickstarter.entity.Category;

public class DefaultCategoryService implements CategoryService {
	List<Category> categories;

	public DefaultCategoryService(DatabaseService databaseService) {
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
}
