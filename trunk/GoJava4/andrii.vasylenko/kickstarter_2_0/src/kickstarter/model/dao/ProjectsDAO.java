package kickstarter.model.dao;

import java.sql.SQLException;
import java.util.List;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.engine.Project;

public interface ProjectsDAO {
	void addProject(int categoryId, String name, String description, int totalAmount, int daysLeft, String history,
			String link) throws SQLException;

	List<Project> getProjects(int categoryId) throws SQLException;

	Project getProject(int id, int categoryId) throws NoSuchDataException, SQLException;

	void createTableProjects() throws SQLException;
}
