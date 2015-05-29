package kickstarter.model.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;

public class CollectionsStorage implements Storage {
	private List<Quote> quotes = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private Map<Category, List<Project>> projects = new HashMap<>();

	@Override
	public void addQuote(Quote quote) {
		quotes.add(quote);
	}

	@Override
	public Quote getRandomQuote() {
		int index = new Random().nextInt(quotes.size());
		return quotes.get(index);
	}

	@Override
	public void addCategory(Category category) {
		categories.add(category);
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public Category getCategory(int index) {
		return categories.get(index);
	}

	@Override
	public void addProject(Project project, Category category) {
		if (!projects.containsKey(category)) {
			projects.put(category, new ArrayList<Project>());
		}
		projects.get(category).add(project);
	}

	@Override
	public List<Project> getProjects(Category category) {
		return projects.get(category);
	}

	@Override
	public Project getProject(int index, Category category) {
		return projects.get(category).get(index);
	}
}
