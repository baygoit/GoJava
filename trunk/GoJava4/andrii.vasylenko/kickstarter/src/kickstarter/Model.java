package kickstarter;

import java.util.Iterator;
import java.util.Random;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;
import kickstarter.storages.Storage;
import kickstarter.storages.relations.Relations;

public class Model {
	private Storage<Quote> quotes;
	private Storage<Category> categories;
	private Storage<Project> projects;
	private Relations<Project, Category> projectsInCategory;

	public Model(Storage<Quote> quotes, Storage<Category> categories, Storage<Project> projects,
			Relations<Project, Category> projectsInCategory) {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
		this.projectsInCategory = projectsInCategory;
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
		return projectsInCategory.getProjects(category).getIterator();
	}

	public Project getProject(int id, Category category) {
		if (id == Project.EXIT.getId()) {
			return Project.EXIT;
		}

		return projectsInCategory.getProjects(category).getById(id);
	}

	public Project getProjectItem(int id) {
		if (id == Project.EXIT.getId()) {
			return Project.EXIT;
		}

		throw new IndexOutOfBoundsException();
	}
}
