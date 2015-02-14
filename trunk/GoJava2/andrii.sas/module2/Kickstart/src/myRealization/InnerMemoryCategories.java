package myRealization;

import java.util.ArrayList;
import java.util.List;

public class InnerMemoryCategories implements Categories {
	private List<Category> categories = new ArrayList<>();
	private int i = 1;
	private String categoriesList;
	
	@Override
	public void addCategory(Category category){
		categories.add(category);
	}
	
	private boolean isLastCategory() {
		return i == getLenth();
	}
	
	private void writeLastCategory(Category category) {
		categoriesList += i + " - " + category.getName();
	}
	
	private void writeCategories(Category category) {
		categoriesList += i + " - " + category.getName() + ", ";
	}
	
	private void concatCategories(Category category) {
		if (isLastCategory()) {
			writeLastCategory(category);
		} else {
			writeCategories(category);
			i++;
		}
	}
	
	@Override
	public String getCategories() {
		categoriesList = "";
		for (Category category : categories) {
			concatCategories(category);
		}
		i = 1;
		return categoriesList;
	}
	
	@Override
	public Category readCategory(int index){
		return categories.get(index);
	}
	
	@Override
	public int getLenth(){
		return categories.size();
	}
	
}
