package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.List;

public class CategoryStorage {

	private List<Category> categoriesList = new ArrayList<>();

	public List<Category> getAllCategories() {
		return categoriesList;
	}

	public void setCategory(Category categoryName) {
		categoriesList.add(categoryName);
	}

	public Category getCategory(int categoryNumber) {
		return categoriesList.get(categoryNumber);
	}
}
