package com.kickstarter.model;

import java.util.List;

public interface Projects {

	void add(Project project);

	Project get(int index);

	int getSize();

	List<Project> getProjects(Сategory сategory);

}
