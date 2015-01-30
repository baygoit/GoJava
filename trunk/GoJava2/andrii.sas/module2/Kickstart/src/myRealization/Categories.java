package myRealization;

import java.util.ArrayList;
import java.util.List;

public class Categories {
	private List<Category> categories = new ArrayList<>();
	private int i = 1;
	private String categoriesList;
	
	public void addCategory(Category category){
		categories.add(category);
	}
	
	public String getCategories() {
		categoriesList = "";
		for (Category category : categories) {
			if (i == categories.size()) {
				categoriesList += i + " - " + category.getName();
			} else {
				categoriesList += i + " - " + category.getName() + ", ";
				i++;
			}
		}
		i = 1;
		return categoriesList;
	}
	
	public Category readCategory(int index){
		return categories.get(index);
	}
}
