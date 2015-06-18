package kickstarter.model.dao.sub;

import java.sql.SQLException;
import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.model.entity.Project;

public interface ProjectsDAO {
	/**
	 * add new Project for category to DB
	 */
	void addProject(int categoryId, String name, String description, int totalAmount, int daysLeft, String history,
			String link) throws DataBaseException, SQLException;

	/**
	 * return all Projects for category from DB
	 */
	List<Project> getProjects(int categoryId) throws DataBaseException, SQLException;

	/**
	 * return Project for category from DB by id
	 */
	Project getProject(int id, int categoryId) throws DataBaseException, SQLException;

	/**
	 * create table Projects in DB
	 */
	void createTableProjects() throws DataBaseException, SQLException;
}
