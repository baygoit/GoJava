package ua.com.goit.gojava2.vova.kickstarter.service;

import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;

public interface CategoryService {

	void saveCategory(Category category);
	
	List<Category> findAllCategories(); 
	
	void deleteCategoryById(int id);

	Category getCategoryById(int id);
}
