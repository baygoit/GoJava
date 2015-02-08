package ua.home.kickstarter.factory;

import ua.home.kickstarter.model.CategoryStorage;

public class StorageFactory {

	private static CategoryStorage categoryStorage;

	public CategoryStorage getCategoryStorage() {
		if (categoryStorage == null) {
			categoryStorage = new CategoryStorage();
		}
		return categoryStorage;
	}
}