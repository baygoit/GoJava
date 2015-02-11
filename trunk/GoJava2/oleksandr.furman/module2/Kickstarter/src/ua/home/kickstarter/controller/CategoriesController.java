package ua.home.kickstarter.controller;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.factory.StorageFactory;
import ua.home.kickstarter.model.CategoryStorage;

public class CategoriesController {

	private CategoryStorage categoryStorage;

	public CategoriesController() {
		categoryStorage = new StorageFactory().getCategoryStorage();
	}

	public String passContentToView() {
		return categoryStorage.getContent();
	}

	public Category passSpecificContentToView(Integer i) {
		return categoryStorage.getSpecificContent(i);
	}
	
	public int passCategoriesSizeToView() {
		return categoryStorage.getSize();
	}
}
