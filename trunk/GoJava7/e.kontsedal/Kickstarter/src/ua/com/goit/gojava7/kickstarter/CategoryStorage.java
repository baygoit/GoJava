package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryStorage {
	private static List<Category> CATEGORIES = new ArrayList<>();

	public List<Category> getAllCategories() {
		return Collections.unmodifiableList(CATEGORIES);
	}

	public void setCategory(String name) {
		CATEGORIES.add(new Category(name));
	}

	public Category getCategory(int numberOfCategory) {
		return CATEGORIES.get(numberOfCategory);
	}

}
