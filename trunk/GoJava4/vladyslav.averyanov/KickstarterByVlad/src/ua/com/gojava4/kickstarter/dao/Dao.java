package ua.com.gojava4.kickstarter.dao;

import java.util.List;

import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.model.repositories.Repository;

public interface Dao extends Repository {

	Quote getRandomQuote();
	
	List<Project> getAllProjectsOfCategory(int categoryId);

	Category getCategoryById(int categoryId);

}
