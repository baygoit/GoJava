package goit.nz.kickstartermvc.storage;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.Quote;

import java.util.List;

public class FileStorage implements DataStorage {

	@Override
	public List<Quote> getQuotes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getProjects(String chosenCategoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPledgedAmount(String categoryName, int projectIndex,
			int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addQuestion(String categoryName, int projectIndex,
			String question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initStorage() {
		// TODO Auto-generated method stub

	}

}
