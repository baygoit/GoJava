package org.goJava2.kickstarter.controller;

import java.util.List;

import org.goJava2.kickstarter.behavior.ControllerBehavior;
import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.factory.StorageFactory;
import org.goJava2.kickstarter.model.CategoryStorage;

public class CategoryController implements ControllerBehavior<Integer> {
	
	private CategoryStorage categoryStorage;
	
	public CategoryController() {
		categoryStorage = new StorageFactory().getCategoryStorage();
	}
	
	@Override
	public List<Category> passContentToView() {
		return categoryStorage.getContent();
	}
	
	@Override
	public Category passSpecificContentToView(Integer t) {
		return categoryStorage.getSpecificContent(t - 1);
	}
}