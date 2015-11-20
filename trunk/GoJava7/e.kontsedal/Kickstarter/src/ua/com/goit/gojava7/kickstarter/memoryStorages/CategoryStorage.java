package ua.com.goit.gojava7.kickstarter.memoryStorages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryStorage {
	private static List<Category> categories = new ArrayList<>();

	public List<Category> getAllCategories() {
		return Collections.unmodifiableList(categories);
	}

// OLEG setCategory but actual add it
	public void setCategory(String name) {
		categories.add(new Category(name));
	}

// OLEG why -1? Why not start index from 0 in storage methods?
	public Category getCategory(int numberOfCategory) {
		return categories.get(numberOfCategory - 1);
	}

}
