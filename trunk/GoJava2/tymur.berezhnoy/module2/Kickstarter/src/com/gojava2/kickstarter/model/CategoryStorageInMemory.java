package com.gojava2.kickstarter.model;

import java.util.LinkedHashSet;

public class CategoryStorageInMemory implements CategoryStorage {

	private LinkedHashSet<Category> categories;
	
	public CategoryStorageInMemory() {
		categories = new LinkedHashSet<Category>();
	}
	
	@Override
	public LinkedHashSet<Category> getCategories() {
		return categories;
	}
	
	@Override
	public Category getCategory(int i) {
		return (Category) categories.toArray()[i - 1];
	}
	
	@Override
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	@Override
	public int getSize() {
		return categories.size();
	}
}