package ua.home.kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import ua.home.kickstarter.content.Category;

public class CategoryStorage {

	private Map<Integer, Category> categories;
	private int keyCounter;

	public CategoryStorage() {
		categories = new HashMap<Integer, Category>();
		keyCounter = 1;
		init();
	}

	private void init() {
		add(new Category("Games"));
		add(new Category("Technology"));
		add(new Category("Design"));
	}
 
	public Map<Integer, Category> getCategories() {
		return categories;
	}

	public Category getSpecificContent(Integer i) {
		return categories.get(i);
	}

	public void add(Category category) {
		categories.put(keyCounter, category);
		keyCounter++;
	}

	public String getContent() {
		StringBuilder categoriesContent = new StringBuilder();
		for (Map.Entry<Integer, Category> pair : categories.entrySet()) {
			categoriesContent.append(pair.getKey()).append(" - ")
					.append(pair.getValue().getName()).append("\n");
		}
		return categoriesContent.toString();
	}

	public int size() {
		return categories.size();
	}
}