package com.gojava2.kickstarter.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class CategoryStorageInVM {

	private Set<Category> categories;
	
	public CategoryStorageInVM() {
		categories = new LinkedHashSet<Category>();
		categories.add(new Category("Art"));
		categories.add(new Category("Comics"));
		categories.add(new Category("Dance"));
		categories.add(new Category("Games"));
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
}