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
	
	public boolean isLastCategory() {
		return i == categories.size();
	}
	
	public void writeLastCategory(Category category) {
		categoriesList += i + " - " + category.getName();
	}
	
	public void writeCategories(Category category) {
		categoriesList += i + " - " + category.getName() + ", ";
	}
	
	public void concatCategories(Category category) {
		if (isLastCategory()) {
			writeLastCategory(category);
		} else {
			writeCategories(category);
			i++;
		}
	}
	
	public String getCategories() {
		categoriesList = "";
		for (Category category : categories) {
			concatCategories(category);
		}
		i = 1;
		return categoriesList;
	}
	
	public Category readCategory(int index){
		return categories.get(index);
	}
}
