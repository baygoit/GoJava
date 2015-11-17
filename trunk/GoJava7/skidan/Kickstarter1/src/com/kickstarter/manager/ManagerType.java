package com.kickstarter.manager;

import java.util.Map;

import com.kickstarter.model.Project;

public abstract class ManagerType {

	protected ProjectManagerInterface manager;
	
	
	public ManagerType(){
		
		
	}

	public Map<Integer, Project> getAll(String categoryTitle) {

		return manager.getAll(categoryTitle);
	}

	public Project getOne( String categoryTitle, int projectNumber) {

		return manager.getOne(categoryTitle, projectNumber);

	}

	public void setType(ProjectManagerInterface manager) {
		this.manager = manager;
	}
}