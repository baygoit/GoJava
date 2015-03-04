package ua.com.sas.model;

import java.util.ArrayList;
import java.util.List;

public class InnerMemoryCategories implements Categories {
	private List<Category> categories = new ArrayList<Category>();
	
	@Override 
	public void addCategory(Category category){
		categories.add(category);
	}
	
	
	@Override
	public List<Category> getCategories() {
		return categories;
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
