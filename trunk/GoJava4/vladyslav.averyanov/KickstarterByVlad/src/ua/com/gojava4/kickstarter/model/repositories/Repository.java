package ua.com.gojava4.kickstarter.model.repositories;

import java.util.List;

import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Project;

public interface Repository {

	List<Quote> getAllQuotes();

	List<Category> getAllCategories();

	List<Project> getAllProjects();

}
