package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryStorage {
	private List<Category> categories = new ArrayList<>();

	public void add(Category category) {
		categories.add(category);
	}

	public List<Category> getAllCategories() {
		return Collections.unmodifiableList(categories);
	}

	public int size() {
		return categories.size();
	}

	public Category get(int i) {
		return categories.get(i);
	}
}
