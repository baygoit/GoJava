package ua.com.goit.gojava.kickstarter.Model;

import java.util.List;


public interface Categories {
	
	void add(Category category);
	List<Category> getAllCategories();
	Category getSelectCategory(int id);
	

}
