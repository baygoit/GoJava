package ua.com.gojava4.kickstarter.model.repositories;

import java.io.File;
import java.util.List;

import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Quote;

public class FileRepositoryFactory extends AbstractRepositoryFactory {
	
	File file;
	
	FileRepositoryFactory (String factoryType){
		switch (factoryType.toLowerCase()) {
		case "quotes":
			initializeQuotes();
			break;
			
		case "categories":
			initializeCategories();
			break;
			
		case "projects":
			initializeProjects();
			break;

		default:
			break;
		}		
	}

	private void initializeQuotes() {
		// TODO Auto-generated method stub
		
	}

	private void initializeCategories() {
		// TODO Auto-generated method stub
		
	}

	private void initializeProjects() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Quote> getAllQuotes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
