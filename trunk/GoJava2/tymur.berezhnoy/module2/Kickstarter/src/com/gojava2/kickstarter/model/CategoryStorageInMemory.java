package com.gojava2.kickstarter.model;

import java.util.LinkedHashSet;

public class CategoryStorageInMemory {

	private LinkedHashSet<Category> categories;
	
	public CategoryStorageInMemory() {
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
	
	public int getSize() {
		return categories.size();
	}
}