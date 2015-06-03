package kickstarter.model.storage;

import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;

public interface Storage {
	void addQuote(Quote quote) throws CannotAddDataException;

	Quote getRandomQuote() throws CannotGetDataException;

	void addCategory(Category category) throws CannotAddDataException;

	List<Category> getCategories() throws CannotGetDataException;

	Category getCategory(int index) throws CannotGetDataException;

	void addProject(Project project, Category category) throws CannotAddDataException;

	List<Project> getProjects(Category category) throws CannotGetDataException;

	Project getProject(int index, Category category) throws CannotGetDataException;
}
