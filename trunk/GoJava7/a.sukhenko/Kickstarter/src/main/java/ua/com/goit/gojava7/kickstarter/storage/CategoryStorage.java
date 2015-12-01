package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryStorage {
	private List<Category> categories = new ArrayList<Category>();

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public Category getCategoryById(int id) {
		for (Category category : categories) {
			if (category.getCategoryId() == id) {
				return category;
			}
		}
		throw new NoSuchElementException();
	}

	public int size() {
		return categories.size();
	}

	public void addCategory(Category cat) {
		categories.add(cat);
	}

}
