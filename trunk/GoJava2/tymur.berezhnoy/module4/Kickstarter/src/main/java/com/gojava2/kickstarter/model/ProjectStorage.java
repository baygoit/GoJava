package com.gojava2.kickstarter.model;

import java.util.List;

public interface ProjectStorage {
	void addProject(Project project);
	Project getProject(int i);
	List<Project> getProjects(Category category);
	int getSize();
}