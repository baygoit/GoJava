package kickstarter;

import java.util.Iterator;
import java.util.Random;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;
import kickstarter.storages.CategoriesStorage;
import kickstarter.storages.ProjectsStorage;
import kickstarter.storages.QuotesStorage;
import kickstarter.storages.Storage;

public class Model {
	private Storage<Quote> quotes;
	private Storage<Category> categories;
	private Storage<Project> projects;

	public Model() {
		quotes = new QuotesStorage();
		categories = new CategoriesStorage();
		projects = new ProjectsStorage();
	}

	public void addQuote(Quote quote) {
		quotes.add(quote);
	}

	public Quote getRandomQuote() {
		if (quotes.isEmpty()) {
			return null;
		}
		int randomIndex = new Random().nextInt(quotes.size());
		return quotes.get(randomIndex);

		/*
		 * Quote randomQuote = getRandom(); if (randomQuote == null) { return
		 * ""; } return randomQuote.getQuote();
		 * 
		 * return null;
		 */
	}

	// public Quote getQuote(int index) {
	// return quotes.get(index);
	// }
	//
	// public Quote getQuoteById(int id) {
	// return quotes.get(id);
	// }
	//
	// public int quotesSize() {
	// return quotes.size();
	// }

	public void addCategory(Category category) {
		categories.add(category);
	}

	public Iterator<Category> getCategoryIterator() {
		return categories.getIterator();
	}

	// public Category getCategory(int index) {
	// return categories.get(index);
	// }

	public Category getCategoryById(int id) {
		if (id == Category.EXIT.getId()) {
			return Category.EXIT;
		}

		return categories.getById(id);
	}

	//
	// public int categoriesSize() {
	// return categories.size();
	// }

	public void addProject(Project project, Category category) {
		projects.add(project);
	}

	public Iterator<Project> getProjectIterator(Category category) {
		Storage<Project> projectsInCategory = getProjectsInCategory(category);
		return projectsInCategory.getIterator();
	}
	
	public Project getProjectById(int id) {
		if (id == Project.EXIT.getId()) {
			return Project.EXIT;
		}

		return projects.getById(id);
	}

	// public Project getProject(int index) {
	// return projects.get(index);
	// }
	//
	// public Project getProjectById(int id) {
	// return projects.get(id);
	// }
	//
	// public int projectsSize() {
	// return projects.size();
	// }
	//
	private ProjectsStorage getProjectsInCategory(Category category) {
		ProjectsStorage result = new ProjectsStorage();

		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).getCategory() == category) {
				result.add(projects.get(i));
			}
		}

		return result;
	}
}
