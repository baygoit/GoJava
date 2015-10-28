package com.sergiisavin.kickstarter;

import java.util.ArrayList;
import java.util.List;

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
