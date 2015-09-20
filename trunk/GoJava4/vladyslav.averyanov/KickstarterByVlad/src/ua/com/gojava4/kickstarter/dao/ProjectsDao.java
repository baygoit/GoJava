package ua.com.gojava4.kickstarter.dao;

import java.util.List;

import ua.com.gojava4.kickstarter.entities.Project;

public interface ProjectsDao {

	List<Project> getAllProjects();
	
	List<Project> getAllProjectsOfCategory(int categoryId);

}
