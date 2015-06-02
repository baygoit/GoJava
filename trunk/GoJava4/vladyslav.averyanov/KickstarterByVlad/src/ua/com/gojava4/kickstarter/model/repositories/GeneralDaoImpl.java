package ua.com.gojava4.kickstarter.model.repositories;

import java.util.ArrayList;
import java.util.List;

import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Quote;

public class GeneralDaoImpl implements Dao { 
	
	List<Quote> quotes;
	List<Category> categories; 
	List<Project> projects;
	
	public GeneralDaoImpl(Repository quotesRepository, 
			Repository categoriesRepository, 
			Repository projectsRepository) {
		
		this.quotes = quotesRepository.getAllQuotes();
		this.categories = categoriesRepository.getAllCategories();
		this.projects = projectsRepository.getAllProjects();
	}

	private ArrayList<Category> getAllProjectsOfCategory(int categoryId) {
		
		return null;
	}

	@Override
	public List<Quote> getAllQuotes() {
		return quotes;
	}

	@Override
	public List<Category> getAllCategories() {
		return categories;
	}

	@Override
	public List<Project> getAllProjects() {
		return projects;
	}

	@Override
	public Quote getRandomQuote() {
		return null;				
	}
	
}
