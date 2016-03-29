package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public interface CategoryDao {
	
	Category getCategory(int index);
	
	List<Project> getProjectsByCategoryId(int index);
	
	List<Category> getCategories();

}
