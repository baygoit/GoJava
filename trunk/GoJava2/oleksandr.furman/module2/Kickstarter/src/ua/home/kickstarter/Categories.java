package ua.home.kickstarter;

import java.util.HashMap;
import java.util.Map;

public class Categories {

	private Map<Integer, Category> categories = new HashMap<Integer, Category>();
	private int categoryNumber = 1;

	public void add(Category category) {
		categories.put(categoryNumber, category);
		categoryNumber++;
	}

	public Map<Integer, Category> getCategories() {
		return categories;
	}
}
