package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.model.dao.CategoriesDAO;
import kickstarter.model.engine.Category;

public class CategoriesModel implements Model {
	private CategoriesDAO categories;

	public CategoriesModel(CategoriesDAO categories) {
		this.categories = categories;
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		List<String> result = new ArrayList<>();

		for (Category category : categories.getCategories()) {
			result.add(getDescription(category.getId(), category.getName()));
		}

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item) throws CannotGetDataException {
		List<Object> result = new ArrayList<>();

		if (item != 0) {
			int id = item;
			Category category = categories.getCategory(id);
			result.add(category);
		}

		return result;
	}

	private String getDescription(int id, String name) {
		int item = id;
		return String.format("%s - %s", item, name);
	}
}
