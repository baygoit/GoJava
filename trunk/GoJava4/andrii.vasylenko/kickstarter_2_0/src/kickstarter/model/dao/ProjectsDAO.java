package kickstarter.model.dao;

import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Project;

public interface ProjectsDAO {
	void createTableProjects() throws CannotCreateTableException;

	void addProject(int categoryId, String name, String description, int totalAmount, int daysLeft, String history,
			String link) throws CannotAddDataException;

	List<Project> getProjects(int categoryId) throws CannotGetDataException;

	Project getProject(int id, int categoryId) throws CannotGetDataException;
}
