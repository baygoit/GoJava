package ua.com.sas.service;

import java.util.List;

import ua.com.sas.model.Category;

public interface CategoriesService {
	
	Category getWithProjects(int id);

	List<Category> getAll(); 

}
