package ua.com.gojava4.kickstarter.dao;

import java.util.List;

import ua.com.gojava4.kickstarter.entities.Category;

public interface CategoriesDao {
	
	List<Category> getAllCategories();

	Category getCategoryById(int categoryId);

}
