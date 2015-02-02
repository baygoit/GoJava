package org.goJava2.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import org.goJava2.kickstarter.behavior.StorageBehavior;
import org.goJava2.kickstarter.content.Category;

public class CategoryStorage implements StorageBehavior<Integer> {

	private List<Category> categories;
	
	/**
	 * The constructor for Hard-coded categories.
	 */
	public CategoryStorage() {
		categories = new ArrayList<Category>();
		categories.add(new Category("Art"));
		categories.add(new Category("Comics"));
		categories.add(new Category("Dance"));
		categories.add(new Category("Games"));
	}
	
	/**
	 * The constructor for custom categories.
	 * @param categories
	 */
	public CategoryStorage(List<Category> categories) {
		this.categories = categories;
	}
	
	@Override
	public List<Category> getContent() {
		return categories;
	}
	
	@Override
	public Category getSpecificContent(Integer i) {
		return categories.get(i);
	}
}