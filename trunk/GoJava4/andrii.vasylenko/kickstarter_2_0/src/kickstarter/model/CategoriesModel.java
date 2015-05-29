package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.model.engine.Category;
import kickstarter.model.storage.Storage;

public class CategoriesModel implements Model {
	private Storage storage;

	public CategoriesModel(Storage storage) {
		this.storage = storage;
	}

	@Override
	public List<String> getData() {
		List<String> result = new ArrayList<>();

		List<Category> categories = storage.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			result.add(getDescription(category, i));
		}

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item) {
		if (item == 0) {
			return null;
		}

		List<Object> result = new ArrayList<>();
		result.add(storage.getCategory(item - 1));
		return result;
	}

	private String getDescription(Category category, int index) {
		StringBuilder result = new StringBuilder();

		int numberInMenu = index + 1;
		result.append(numberInMenu);
		result.append(" - ");

		result.append(category.getName());

		return result.toString();
	}
}
