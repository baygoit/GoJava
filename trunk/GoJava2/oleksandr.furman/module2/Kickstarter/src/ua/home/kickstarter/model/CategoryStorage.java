package ua.home.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import ua.home.kickstarter.content.Category;

public class CategoryStorage {

	private List<Category> categories;

	public CategoryStorage() {
		categories = new ArrayList<Category>();
		init();
	}

	private void init() {
		add(new Category("Games"));
		add(new Category("Technology"));
		add(new Category("Design"));
	}
 
	public List<Category> getCategories() {
		return categories;
	}

	public Category getSpecificContent(Integer i) {
		return categories.get(i);
	}

	public void add(Category category) {
		categories.add(category);
	}
	
	public String getContent() {
		StringBuilder categoriesContent = new StringBuilder();
		for (int i = 0; i < categories.size(); i++) {
			categoriesContent.append(i+1).append(" - ")
					.append(categories.get(i).getName()).append("\n");
		}
		return categoriesContent.toString();
	}

	public int size() {
		return categories.size();
	}
}