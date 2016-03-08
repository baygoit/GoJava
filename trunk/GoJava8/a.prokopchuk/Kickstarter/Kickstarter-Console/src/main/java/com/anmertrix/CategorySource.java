package com.anmertrix;

import java.util.ArrayList;
import java.util.List;

public class CategorySource {
	
	List<Category> categories = new ArrayList<Category>();
	
	public CategorySource() {
		categories.add(new Category("Sport"));
		categories.add(new Category("IT"));
		categories.add(new Category("Medicine"));
		categories.add(new Category("Photo"));
		categories.add(new Category("Music"));
		categories.add(new Category("Video"));

	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public Category getCategory(int i) {
		return categories.get(i);
	}
	
	public String getCategoriesMenu() {
		StringBuffer result = new StringBuffer();
		result.append("Please, select category: \n");
		for(int i = 0; i < categories.size(); i++) {
			result.append(i + 1).append(" - ").append(categories.get(i).getName()).append("    ");
		}
		
		return result.toString().trim();
	}
	
	public String getNameSelectedCategory(int n) {
		return categories.get(n).getName();
	}
	
}
