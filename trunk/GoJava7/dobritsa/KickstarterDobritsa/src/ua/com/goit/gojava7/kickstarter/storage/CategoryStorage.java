package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryStorage {

	private List<Category> categories = new ArrayList<Category>();

	public void add(Category category) {
		categories.add(category);
	}

	public List<Category> getAll() {
		return Collections.unmodifiableList(categories);
	}

	public Category get(int index) {
		return categories.get(index);
	}

	public int size() {
		return categories.size();
	}
}
