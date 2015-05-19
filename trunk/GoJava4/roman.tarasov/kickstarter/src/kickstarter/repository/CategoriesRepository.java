package kickstarter.repository;

import kickstarter.entities.Category;

public class CategoriesRepository {
	iStorage<Category> categories;

	public CategoriesRepository() {
		categories = new EntityStorage<Category>();
		Category category = new Category("Technology");
		category.ID = 5;
		categories.add(category);

		category = new Category("Social");
		category.ID = 4;
		categories.add(category);
	}

	public Category getCategory(int index) {
		return categories.getEntity(index);
	}

	public int getCategoriesLength() {
		return categories.length();
	}
}
