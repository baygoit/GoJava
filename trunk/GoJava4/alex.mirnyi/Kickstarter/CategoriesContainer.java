package Kickstarter;

import java.util.ArrayList;
import java.util.List;

public class CategoriesContainer {
	public List<Category> categories;
	
	public CategoriesContainer() {
		categories = new ArrayList<Category>();
	}
	
	public Category get(int index) throws IndexOutOfBoundsException {
		return categories.get(index);
	}
	
	public int size() {
		return categories.size();
	}
	
	public void add(Category category) {
		categories.add(category);
	}
	
	public List<Category> getCategories() {
		return categories;
	}
}
