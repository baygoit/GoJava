package com.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryStorage {
	private List<Сategory> categories;
	
	public CategoryStorage() {
		categories = new ArrayList<Сategory>();
	}
	
	public void addCategory(Сategory category) {
		categories.add(category);
	}
	
	public List<Сategory> getCategoriesList() {
		return categories;
	}
	
	public Сategory getSpecificCategory(int index) {
		return categories.get(index - 1); 
	}
	
	public int getSizeCategories() {
		return categories.size();
	}

}