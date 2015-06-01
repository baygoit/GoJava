package ua.com.gojava4.kickstarter.model.repositories;

import java.util.List;
import java.util.Locale.Category;

import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Quote;

public interface Repository {

	List<Quote> getAllQuotes();

	List<Project> getAllProjects();

	List<Category> getAllCategories();

}
