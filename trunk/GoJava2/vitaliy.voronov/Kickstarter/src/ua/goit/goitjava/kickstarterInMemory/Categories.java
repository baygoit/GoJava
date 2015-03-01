package ua.goit.goitjava.kickstarterInMemory;

import java.util.ArrayList;

import ua.goit.goitjava.kickstarter.Category;

public class Categories {
	
	private ArrayList<Category> categoriesList = new ArrayList<>();
	
	
	public void addCategory(Category category){
		categoriesList.add(category);
	}
	
	public ArrayList<Category> getCategory() {
		return categoriesList;
	}
	
	public Category getCategoryByIndex(int index) {
		Category categoryByIndex = categoriesList.get(index);
		return categoryByIndex;
	}
}
