package com.kickstarter.manager;

import java.util.HashMap;
import java.util.Map;

import com.kickstarter.db.ProjectDB;
import com.kickstarter.model.Project;

public class ProjectManager {

	ProjectDB pdb = new ProjectDB();

	public Map<Integer, Project> getProjectsForCategory(String categoryTitle) {
		return pdb.allProjectsList.get(categoryTitle);

	}

	public Map<Integer, Project> getProject(String categoryTitle, int projectNumber) {
		Map<Integer, Project> list = new HashMap<>();
		Project p = pdb.allProjectsList.get(categoryTitle).get(projectNumber);
		list.put(0, p);
		return list;

	}

}
