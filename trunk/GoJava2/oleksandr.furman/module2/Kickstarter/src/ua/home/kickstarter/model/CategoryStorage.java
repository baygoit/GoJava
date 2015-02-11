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

	public Map<Integer, Category> getCategories() {
		return categories;
	}

	public Category getSpecificContent(Integer i) {
		return categories.get(i);
	}

	public String getContent() {
		StringBuilder categoriesContent = new StringBuilder();
		for (Map.Entry<Integer, Category> pair : categories.entrySet()) {
			categoriesContent.append(pair.getKey()).append(" - ").append(pair.getValue().getName()).append("\n");
		}
		return categoriesContent.toString();
	}

	public int getSize() {
		return categories.size();
	}
}