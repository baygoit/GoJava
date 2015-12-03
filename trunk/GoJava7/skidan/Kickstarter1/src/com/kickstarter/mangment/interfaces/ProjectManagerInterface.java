package com.kickstarter.mangment.interfaces;

import java.util.Map;

import com.kickstarter.model.Project;

interface ProjectManagerInterface {

	public Map<Integer, Project> getAll(String categoryTitle);

	public Project getOne(String categoryTitle, int projectNumber);
	
	public Map<Integer, Project> getWholeProjectMap();

}
