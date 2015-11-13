package com.kickstarter.manager;

import java.util.HashMap;
import java.util.Map;

import com.kickstarter.db.ProjectDB;
import com.kickstarter.model.Project;

public class ProjectManager   {

	ProjectDB pdb = new ProjectDB();

	public Map<Integer, Project> getProjectsForCategory(String categoryTitle) {
		Map<Integer, Project> allProjects = pdb.allProjectsList;
		Map<Integer, Project> categoryProjects = new HashMap<>();
		for (Project p : allProjects.values()) {
			if (p.getCategoryName().equals(categoryTitle)) {
				categoryProjects.put(p.getId(), p);
			}
		}
		return categoryProjects;

	}

	public Project getProject(String categoryTitle, int projectNumber) {
		Map<Integer, Project> requiredCategoryProjects = getProjectsForCategory(categoryTitle);
		Project p = requiredCategoryProjects.get(projectNumber);
		Map<Integer, Project> singleRequredProjectList = getProjectsForCategory(categoryTitle);
		singleRequredProjectList.put(0, p);
		return p;

	}

	

}
