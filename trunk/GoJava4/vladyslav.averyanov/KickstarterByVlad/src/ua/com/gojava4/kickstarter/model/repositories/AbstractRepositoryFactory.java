package ua.com.gojava4.kickstarter.model.repositories;

import java.util.List;
import java.util.Locale.Category;

import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Quote;

public abstract class AbstractRepositoryFactory implements Repository {
	
	@Override
	public List<Quote> getAllQuotes() {
		return null;
	}
	
	@Override
	public List<Project> getAllProjects() {
		return null;
	}
	
	@Override
	public List<Category> getAllCategories() {
		return null;
	}

}
