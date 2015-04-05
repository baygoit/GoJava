package ua.com.sas.model;

import java.util.List;

public interface Categories {

	void add(Category category);
	
	List<Category> getCategories();
	
	Category get(int id);

}