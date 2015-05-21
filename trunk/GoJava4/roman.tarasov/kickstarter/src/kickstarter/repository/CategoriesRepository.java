package kickstarter.repository;

import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.Category;

public class CategoriesRepository {
	List<Category> categories;

	public CategoriesRepository() {
		categories = new ArrayList<Category>();
		Category category = new Category("Technology");
		category.ID = 5;
		categories.add(category);

		category = new Category("Social");
		category.ID = 4;
		categories.add(category);
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}

	public int getCategoriesLength() {
		return categories.size();
	}
}
