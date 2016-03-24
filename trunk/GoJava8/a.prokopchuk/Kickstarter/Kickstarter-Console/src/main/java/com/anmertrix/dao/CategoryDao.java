package com.anmertrix.dao;

import java.util.ArrayList;
import java.util.List;

import com.anmertrix.Category;
import com.anmertrix.Project;

public interface CategoryDao {
	
	List<Category> categories = new ArrayList<Category>();
	
	Category getCategory(int index);
	
	List<Project> getProjectsByCategoryId(int index);
	
	List<Category> getCategories();

}
