package ua.com.scread.kickstarter;

import java.util.ArrayList;

public class Categories {

	private ArrayList<Category> categories;

	public Categories() {
		categories = new ArrayList<Category>();
	}
		
	public void add(Category category) {
		categories.add(category);	
	}
	
	
	public String[] getCategories() {
		String[] result = new String[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			result[i] = String.valueOf(i+1) + " - " + categories.get(i).getName();
		}
		return result;
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}

}
