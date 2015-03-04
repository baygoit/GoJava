package ua.com.sas.model;

import java.util.ArrayList;
import java.util.List;

public class InnerMemoryProjects implements Projects {
	private List<Project> projects = new ArrayList<Project>();
	private List<Project> categoryProjects = new ArrayList<Project>();

	@Override
	public void addProject(Project project) {
		projects.add(project);
	}

	@Override
	public List<Project> chooseProjects(Category category) {
		categoryProjects.clear();
		for (Project project : projects) {
			if (project.getCategory().equals(category)) {
				categoryProjects.add(project);
			}
		}
		return categoryProjects;		
	}

	@Override
	public Project readObject(int index) {
		return categoryProjects.get(index);
	}

	@Override
	public int getLenth() {
		return categoryProjects.size();
	}
}
