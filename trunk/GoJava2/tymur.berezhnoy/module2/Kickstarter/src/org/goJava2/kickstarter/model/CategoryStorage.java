package org.goJava2.kickstarter.model;

import java.util.HashSet;
import java.util.Set;

import org.goJava2.kickstarter.behavior.StorageBehavior;
import org.goJava2.kickstarter.content.Category;

public class CategoryStorage implements StorageBehavior<Integer> {

	private Set<Category> categories;
	
	/**
	 * The constructor for Hard-coded categories.
	 */
	public CategoryStorage() {
		categories = new HashSet<Category>();
		categories.add(new Category("Art"));
		categories.add(new Category("Comics"));
		categories.add(new Category("Dance"));
		categories.add(new Category("Games"));
	}
	
	/**
	 * The constructor for custom categories.
	 * @param categories
	 */
	public CategoryStorage(Set<Category> categories) {
		this.categories = categories;
	}
	
	@Override
	public Set<Category> getContent() {
		return categories;
	}
	
	@Override
	public Category getSpecificContent(Integer i) {			
		Category cat = (Category) categories.toArray()[i];
		return cat; 
	}
	
	@Override
	public void addContent(Object o) {
		categories.add((Category) o);
	}
}