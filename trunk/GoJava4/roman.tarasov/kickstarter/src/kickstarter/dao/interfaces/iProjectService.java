package kickstarter.dao.interfaces;


import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.Project;

public interface iProjectService {


	int getProjectsLength() throws SQLException;

	Project getProjectById(int intSelectedProject) throws SQLException;

	List<Project> getAll();

	void createProjects(iDAO interfaceDAO) throws SQLException;

	List<Project> sortProjectsByCategoryID(int categoryID) throws SQLException;

	void updateProject(Project project) throws SQLException;
}
