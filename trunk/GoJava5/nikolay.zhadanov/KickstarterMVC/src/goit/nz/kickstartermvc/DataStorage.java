package goit.nz.kickstartermvc;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.Quote;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

	private List<Quote> quotes;
	private List<Category> categories;
	private List<Project> projects;

	public DataStorage() {
		quotes = new ArrayList<>();
		categories = new ArrayList<>();
		projects = new ArrayList<>();
	}

	public void registerQuotes(List<Quote> quotes) {
		this.quotes.addAll(quotes);
	}

	public void registerCategories(List<Category> categories) {
		this.categories.addAll(categories);
	}

	public void registerProjects(List<Project> projects) {
		this.projects.addAll(projects);
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Project> getProjects(String chosenCategoryName) {
		List<Project> result = new ArrayList<>();
		for (Project project : projects) {
			if (project.getCategory().getName().equals(chosenCategoryName)) {
				result.add(project);
			}
		}
		return result;
	}

	public void addPledgedAmount(String categoryName, int projectIndex,
			int amount) {
		getProjects(categoryName).get(projectIndex - 1)
				.addPledgedAmount(amount);
	}

}
