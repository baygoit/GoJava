package kickstarter.interfaces.display;

import kickstarter.engine.Category;

public class CategoryDisplay implements Display<Category> {

	@Override
	public String getDescription(Category category) {
		return category.getId() + " - " + category.getName();
	}

	@Override
	public String getDetailedDescription(Category category) {
		return getDescription(category);
	}

}
