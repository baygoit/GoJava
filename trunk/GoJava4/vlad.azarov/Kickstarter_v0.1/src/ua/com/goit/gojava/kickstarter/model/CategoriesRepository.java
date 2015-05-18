package ua.com.goit.gojava.kickstarter.model;

import java.util.ArrayList;

public class CategoriesRepository {
    
    private ArrayList<Category> categories;
    
    public CategoriesRepository(){
	categories = new ArrayList<>();
	
	add(new Category("DESIGN", 1));
	add(new Category("TECHNOLOGY", 2));
    }
    
    public ArrayList<Category> getCategories(){
	return categories;
    }
    
    public Category getById (int id){
	for (Category category : categories){
	    if (id == category.getId()){
		return category;
	    }
	}
	return null;
    }
    
    public void add(Category category){
	categories.add(category);
    }    
}
