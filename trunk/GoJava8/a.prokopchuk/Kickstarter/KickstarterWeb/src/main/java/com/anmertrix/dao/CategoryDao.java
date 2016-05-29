package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Category;

public interface CategoryDao {
	
	List<Category> getCategories();

	boolean isExists(long categoryId);

	Category getCategory(long categoryId);
	
}
