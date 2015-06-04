package kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.Project;

public interface iProjectService {

	Project getProjectByIndex(int index);

	int getProjectsLength();

	Project getProjectById(int intSelectedProject);

	List<Project> getAll();

	void createProjects(iDAO interfaceDAO, Connection connection) throws SQLException;
}
