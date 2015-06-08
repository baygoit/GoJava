package ua.com.gojava4.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.model.repositories.Repository;

public class GenericDaoImpl implements Dao { 
	
	List<Quote> quotes;
	List<Category> categories; 
	List<Project> projects;
	
	public GenericDaoImpl(Repository quotesRepository, 
			Repository categoriesRepository, 
			Repository projectsRepository) {
		
		this.quotes = quotesRepository.getAllQuotes();
		this.categories = categoriesRepository.getAllCategories();
		this.projects = projectsRepository.getAllProjects();
	}

	public List<Project> getAllProjectsOfCategory(int categoryId) {
		List<Project> result = new ArrayList<>();
		for (Project project : projects){
			if (project.getCategoryId() == categoryId){
				result.add(project);
			}
		}
		return result;
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
		Random rnd = new Random();
		return quotes.get(rnd.nextInt(quotes.size()-1));				
	}
	
}
