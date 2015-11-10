package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryStorage {
	private static List<Category> categories = new ArrayList<>();

	public List<Category> getAllCategories() {
		return Collections.unmodifiableList(categories);
	}

	public void setCategory(String name) {
		categories.add(new Category(name));
	}

	public Category getCategory(int numberOfCategory) {
		return categories.get(numberOfCategory - 1);
	}

}
