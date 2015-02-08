package ua.home.kickstarter.controller;

import java.util.Map;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.factory.StorageFactory;
import ua.home.kickstarter.model.CategoryStorage;

public class CategoriesController {

	private CategoryStorage categoryStorage;

	public CategoriesController() {
		categoryStorage = new StorageFactory().getCategoryStorage();
	}

	public Map<Integer, Category> passContentToView() {
		return categoryStorage.getContent();
	}

	public Category passSpecificContentToView(Integer i) {
		return categoryStorage.getSpecificContent(i);
	}
}
