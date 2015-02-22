package com.gojava2.kickstarter.controller;

import java.util.Set;

import com.gojava2.kickstarter.behavior.ControllerBehavior;
import com.gojava2.kickstarter.content.Category;
import com.gojava2.kickstarter.factory.StorageFactory;
import com.gojava2.kickstarter.model.CategoryStorage;

public class CategoryController implements ControllerBehavior<Integer> {
	
	private CategoryStorage categoryStorage;
	
	public CategoryController() {
		categoryStorage = new StorageFactory().getCategoryStorage();
	}
	
	@Override
	public Set<Category> getContent() {
		return (Set<Category>) categoryStorage.getContent();
	}
	
	@Override
	public Category getSpecificContent(Integer t) {
		return (Category) categoryStorage.getSpecificContent(t);
	}
}