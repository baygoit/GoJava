package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryStorage {
	private ArrayList<Category> categories = new ArrayList<>();
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public ArrayList<Category> getAllCategories() {
		return categories;
	}
	
	public Category getCategory(int i) {
		return categories.get(i);
	}
}