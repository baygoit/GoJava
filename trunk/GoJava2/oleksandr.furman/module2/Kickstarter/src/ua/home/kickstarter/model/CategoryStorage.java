package ua.home.kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import ua.home.kickstarter.content.Category;

public class CategoryStorage {

	private Map<Integer, Category> categories;

	public CategoryStorage() {
		categories = new HashMap<Integer, Category>();
		categories.put(1, new Category("Games"));
		categories.put(2, new Category("Technology"));
		categories.put(3, new Category("Design"));
	}

	public Map<Integer, Category> getContent() {
		return categories;
	}

	public Category getSpecificContent(Integer i) {
		return categories.get(i);
	}	
}