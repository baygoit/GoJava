package edu.kickstarter.Dao.categoryService;

import java.util.ArrayList;
import java.util.List;
import edu.kickstarter.entity.Category;

public class DefaultCategoryServiceImpl implements CategoryService {
	List<Category> categories;

	public DefaultCategoryServiceImpl() {
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
