package goit.nz.kickstartermvc.storage;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.Quote;

import java.util.List;

public interface DataStorage {

	List<Quote> getQuotes();

	List<Category> getCategories();

	List<Project> getProjects(String chosenCategoryName);

	void addPledgedAmount(String categoryName, int projectIndex,
			int amount);

	void addQuestion(String categoryName, int projectIndex,
			String question);
	
	void initStorage();

}
