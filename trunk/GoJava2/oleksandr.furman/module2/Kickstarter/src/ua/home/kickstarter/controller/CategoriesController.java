package ua.home.kickstarter.controller;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.model.CategoryStorage;

public class CategoriesController {

	private CategoryStorage categoryStorage;

	public CategoriesController() {
		categoryStorage = new CategoryStorage();
	} 

	public String getContentToView() {
		return categoryStorage.getContent();
	}

	public Category getSpecificContentToView(Integer i) {
		return categoryStorage.getSpecificContent(i);
	}
	
	public int getCategoriesSizeToView() {
		return categoryStorage.size();
	}
}
