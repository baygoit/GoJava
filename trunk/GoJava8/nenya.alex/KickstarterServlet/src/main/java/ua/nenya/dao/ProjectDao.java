package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Project;

public interface ProjectDao {

	List<Project> getProjects(int id);
	Project getProject(int proId);
	boolean isProjectExist(int proId);
	int getCategoryId(int proId);
}
