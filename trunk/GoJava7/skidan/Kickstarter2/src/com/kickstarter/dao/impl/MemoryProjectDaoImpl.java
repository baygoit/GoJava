package com.kickstarter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.kickstarter.dao.interfaces.ProjectDaoInterface;
import com.kickstarter.memory.storage.ProjectDB;
import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

public class MemoryProjectDaoImpl implements ProjectDaoInterface {

	ProjectDB pdb = new ProjectDB();

	public List<Project> getAll(String categoryTitle) {
		List<Project> allProjects = ProjectDB.allProjectsList;
		List<Project> categoryProjects = new ArrayList<>();
		for (Project p : allProjects) {
			if (p.getCategoryName().equals(categoryTitle)) {
				categoryProjects.add(p);
			}
		}
		return categoryProjects;

	}

	public Project getOne(int projectNumber) {
		Project p = new Project();
		List<Project> requiredCategoryProjects = getAllList();
		for (Project project : requiredCategoryProjects) {
			if (project.getId() == projectNumber) {
				p = project;
			} else {
				continue;
			}
		}
		return p;

	}

	public List<Project> getAllList() {
		List<Project> allProjects = ProjectDB.allProjectsList;
		return allProjects;
	}

	public void update(Project p) {
		List<Project> allProjects = ProjectDB.allProjectsList;
		int i = 0;
		for (Project project : allProjects) {
			if (project.getCategoryName().equals(p.getCategoryName())) {
				allProjects.remove(i);
				allProjects.add(i, p);
				break;
			} else {
				i++;
				continue;
			}

		}

	}

}
