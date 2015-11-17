package com.kickstarter.manager;

import java.util.Map;

import com.kickstarter.model.Project;

interface ProjectManagerInterface {

	public Map<Integer, Project> getAll(String categoryTitle);

	public Project getOne(String categoryTitle, int projectNumber);

}
