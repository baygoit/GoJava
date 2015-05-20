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
import kickstarter.storages.relations.ProjectsInCategory;
import kickstarter.storages.relations.Relations;

public class Model {
	private Storage<Quote> quotes;
	private Storage<Category> categories;
	private Storage<Project> projects;
	private Relations<Project, Category> projectsInCategory;

	public Model() {
		quotes = new QuotesStorage();
		categories = new CategoriesStorage();
		projects = new ProjectsStorage();
		projectsInCategory = new ProjectsInCategory();
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
	}

	public void addCategory(Category category) {
		categories.add(category);
	}

	public Iterator<Category> getCategoriesIterator() {
		return categories.getIterator();
	}

	public Category getCategory(int id) {
		if (id == Category.EXIT.getId()) {
			return Category.EXIT;
		}

		return categories.getById(id);
	}

	public void addProject(Project project, Category category) {
		projects.add(project);
		projectsInCategory.add(project, category);
	}

	public Iterator<Project> getProjectsIterator(Category category) {
		return getProjectsInCategory(category).getIterator();
	}

	public Project getProject(int id, Category category) {
		if (id == Project.EXIT.getId()) {
			return Project.EXIT;
		}

		return getProjectsInCategory(category).getById(id);
	}

	public Project getProjectItem(int id) {
		if (id == Project.EXIT.getId()) {
			return Project.EXIT;
		}

		throw new IndexOutOfBoundsException();
	}

	private Storage<Project> getProjectsInCategory(Category category) {
		return projectsInCategory.getProjects(category);
	}
}
