package ua.com.goit.gojava7.kickstarter.storage;

import java.io.FileNotFoundException;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.file.FileWorker;

public class CategoryStorage extends Storage<Category> {
	public CategoryStorage(){		
	}
	
	public void initCategories(String fileName) throws FileNotFoundException {		
		add(FileWorker.readCategory(fileName));		
	}
}
