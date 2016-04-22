package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Category;

public interface CategoryDao {
	
	Category getCategory(int index);
	
	List<Category> getCategories();

	boolean categoryExists(int categoryId);
	
}
