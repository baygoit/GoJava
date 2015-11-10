
package ua.com.goit.gojava7.kickstarter.storage;

import ua.com.goit.gojava7.kickstarter.model.Category;
import java.util.Set;
import java.util.TreeSet;

public class CategoriesStorage {
	private Set<Category> categories;
	
	public CategoriesStorage() {
		categories = new TreeSet<>();
	}
	
	public Set<Category> getAllCategories() {
		return categories;
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public void deleteCategory(Category category) {
		categories.remove(category);
	}
}
