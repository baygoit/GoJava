package ua.goit.goitjava.kickstarter;

import java.util.ArrayList;

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
