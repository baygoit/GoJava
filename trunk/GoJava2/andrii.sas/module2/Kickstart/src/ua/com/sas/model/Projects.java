package ua.com.sas.model;

import java.util.List;

public interface Projects {

	void add(Project project);

	List<Project> getProjects(Category category);

	Project get(int id);

	int size();

}