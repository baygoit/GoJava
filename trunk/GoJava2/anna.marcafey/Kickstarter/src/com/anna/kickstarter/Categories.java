package com.anna.kickstarter;

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
	
	public String[] getCategories() {
        String[] result = new String[categories.size()];
        for (int index = 0; index < categories.size(); index++) {
                result[index] = String.valueOf(index + 1) + " - " + categories.get(index).getName();
        }
        return result;
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}	

}
