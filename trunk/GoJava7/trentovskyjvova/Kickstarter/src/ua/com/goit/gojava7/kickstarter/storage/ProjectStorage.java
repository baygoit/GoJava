package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectStorage {
	private List<Project> projects = new ArrayList<>();

	public List<Project> getProjects() {
		return Collections.unmodifiableList(projects);
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public Project getProject(int projectId) {
		Project result = null;
		for (Project project : projects) {
			if(project.getId() == projectId){
				result = project;
				break;
			}
		}
		return result;
	}
}
