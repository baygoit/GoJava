package kickstarter.model.storage;

import java.util.List;

import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;

public interface Storage {
	void addQuote(Quote quote);

	Quote getRandomQuote();

	void addCategory(Category category);

	List<Category> getCategories();

	Category getCategory(int index);

	void addProject(Project project, Category category);

	List<Project> getProjects(Category category);

	Project getProject(int index, Category category);
}
