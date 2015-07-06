package goit.nz.kickstarter;

import java.util.ArrayList;

public class CategoryList {
	private ArrayList<Category> categories;
	
	public CategoryList() {
		categories = new ArrayList<Category>();
	}
	
	public void add(Category category) {
		categories.add(category);
	}
	
	public int size() {
		return categories.size();
	}
	
	public String[] getList() {
		int size = categories.size();
		String[] result = new String[size];
		for (int index = 0; index < size; index++) {
			result[index] = categories.get(index).getName();
		}
		return result;
	}
	
	public Category getCategory(int index) {
		return categories.get(index);
	}
}
