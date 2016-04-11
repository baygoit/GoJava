package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Project;

public interface ProjectDao {

	List<Project> getProjects(String categoryName);
	Project getProjectByName(String projectName);
}
