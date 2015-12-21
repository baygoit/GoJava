package ua.com.goit.gojava7.kikstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kikstarter.domain.Project;

public interface ProjectDao {
	
	void add(Project project);
	
	List<Project> getAll();
	
	List<Project> getProjectsFromCategory(int categoryId);
	
	int getSize();
	
	void remove(Project project);

}
