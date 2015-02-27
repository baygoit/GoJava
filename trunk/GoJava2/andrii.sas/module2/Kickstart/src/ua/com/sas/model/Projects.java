package ua.com.sas.model;

import java.util.List;

public interface Projects {

	void addProject(Project project);

	List<Project> chooseProjects(Category category);

	Project readObject(int index);

	int getLenth();

}