package com.gojava2.kickstarter.model;

import java.util.LinkedHashSet;

public class CategoryStorageInVM {

	private LinkedHashSet<Category> categories;
	
	public CategoryStorageInVM() {
		categories = new LinkedHashSet<Category>();
	}
	
	public LinkedHashSet<Category> getCategories() {
		return categories;
	}
	
	public Category getCategory(int i) {
		return (Category) categories.toArray()[i - 1];
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
}