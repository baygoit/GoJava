package com.gojava2.kickstarter.controller;

import java.util.LinkedHashSet;

import com.gojava2.kickstarter.content.Category;
import com.gojava2.kickstarter.factory.StorageFactory;
import com.gojava2.kickstarter.model.CategoryStorage;

public class CategoryController implements Controller<Integer> {
	
	private CategoryStorage categoryStorage;
	
	public CategoryController() {
		categoryStorage = new StorageFactory().getCategoryStorage();
	}
	
	@Override
	public LinkedHashSet<Category> getContent() {
		return (LinkedHashSet<Category>) categoryStorage.getContent();
	}
	
	@Override
	public Category getSpecificContent(Integer i) {
		Category cat = (Category) categoryStorage.getContent().toArray()[i];
		return cat;
	}
}