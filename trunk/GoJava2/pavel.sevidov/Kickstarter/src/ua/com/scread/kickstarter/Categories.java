package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Categories {

	private List<Category> categories;

	public Categories() {
		categories = new ArrayList<Category>();
	}
		
	public void add(Category category) {
		categories.add(category);	
	}
	
	
	public String[] getStringCategories() {
		String[] result = new String[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			result[i] = String.valueOf(i+1) + " - " + categories.get(i).getName();
		}
		return result;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}

}
