package com.gojava2.kickstarter.model;

import java.util.LinkedHashSet;

public interface CategoryStorage {
	int getSize();
	void addCategory(Category category);
	Category getCategory(int i);
	LinkedHashSet<Category> getCategories();
}