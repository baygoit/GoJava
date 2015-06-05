package kickstarter.container;

import java.util.ArrayList;

import kickstarter.model.Category;

public class CategoriesContainer extends EntityContainer<Category>{
	public CategoriesContainer() {
		data = new ArrayList<Category>();
	}
}
