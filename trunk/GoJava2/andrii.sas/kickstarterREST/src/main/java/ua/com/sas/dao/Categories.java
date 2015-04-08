package ua.com.sas.dao;

import java.util.List;

import ua.com.sas.model.Category;

public interface Categories {

	void add(Category category);
	
	List<Category> getCategories();
	
	Category get(int id);

}