package com.sergiisavin.kickstarter.project.container.memory;

import java.util.ArrayList;
import java.util.List;

import com.sergiisavin.kickstarter.project.Project;
import com.sergiisavin.kickstarter.project.container.Projects;

public class ProjectsContainer implements Projects {

	private List<Project> projects;
	
	public ProjectsContainer(){
		projects = new ArrayList<Project>();
	}
	
	@Override
	public void add(Project project) {
		projects.add(project);	
	}

	@Override
	public int getSize() {
		return projects.size();
	}

	@Override
	public Project getProject(int index) {
		return projects.get(index);
	}

}
