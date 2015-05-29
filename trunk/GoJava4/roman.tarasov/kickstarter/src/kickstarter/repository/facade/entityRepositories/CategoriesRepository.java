package kickstarter.repository.facade.entityRepositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kickstarter.repository.facade.entity.Category;

public class CategoriesRepository implements Serializable {

	private static final long serialVersionUID = -3600780897479968861L;

	ArrayList<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categoriesToCopy) {
		
		categories = new ArrayList<Category>();
		for (Category category : categoriesToCopy) {
			categories.add(category);
		}
	}

}
