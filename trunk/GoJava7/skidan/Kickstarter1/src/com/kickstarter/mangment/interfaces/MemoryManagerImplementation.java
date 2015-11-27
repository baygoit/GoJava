package com.kickstarter.mangment.interfaces;

import java.util.HashMap;
import java.util.Map;

import com.kickstarter.db.ProjectDB;
import com.kickstarter.model.Project;

public class MemoryManagerImplementation implements ProjectManagerInterface {
	ProjectDB pdb = new ProjectDB();

	public  Map<Integer, Project> getAll(String categoryTitle) {
		Map<Integer, Project> allProjects = pdb.allProjectsList;
		Map<Integer, Project> categoryProjects = new HashMap<>();
		for (Project p : allProjects.values()) {
			if (p.getCategoryName().equals(categoryTitle)) {
				categoryProjects.put(p.getId(), p);
			}
		}
		return categoryProjects;

	}

	public Project getOne(String categoryTitle, int projectNumber) {
		Map<Integer, Project> requiredCategoryProjects = getAll(categoryTitle);
		Project p = requiredCategoryProjects.get(projectNumber);
		Map<Integer, Project> singleRequredProjectList = getAll(categoryTitle);
		singleRequredProjectList.put(0, p);
		return p;

	}

	
	public Map<Integer, Project> getWholeProjectMap() {
		return null;
	}

	

}
