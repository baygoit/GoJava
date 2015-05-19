package ua.com.sas.service;

import java.util.List;
import java.util.Random;

import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.model.Quote;

public interface ProjectsService {
	
	void addCategory(Category category);
	
	Category getWithProjects(int id);

	List<Category> getAll();
	
	Project getCurrent(int id);
	
	Quote getRandomed(Random random);

}