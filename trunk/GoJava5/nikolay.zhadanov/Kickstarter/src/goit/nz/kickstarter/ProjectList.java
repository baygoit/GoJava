package goit.nz.kickstarter;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project> projects;
	
	public ProjectList() {
		projects = new ArrayList<Project>();
	}
	
	public void add(Project project) {
		projects.add(project);
	}
	
	public int size() {
		return projects.size();
	}
	
	public ArrayList<Project> get(Category category) {
		ArrayList<Project> found = new ArrayList<Project>();
		for (Project p : projects) {
			if (p.getCategory() == category) {
				found.add(p);
			}
		}
		return found;
	}
}
