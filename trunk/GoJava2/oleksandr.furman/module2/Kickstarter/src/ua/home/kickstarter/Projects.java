package ua.home.kickstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Projects {

	private Map<Category, List<Project>> projects = new HashMap<Category, List<Project>>();
	
	public void add(Project project) {
		
		if (projects.containsKey(project.getCategory())) {
			projects.get(project.getCategory()).add(project);
		} else {
			ArrayList<Project> projectsList = new ArrayList<Project>();
			projectsList.add(project);
			projects.put(project.getCategory(), projectsList);
		}
	}

	public List<Project> getProjects(Category category) {
		return projects.get(category);
	}

	public Project getFullProject(int index, Category category) {
		return projects.get(category).get(index - 1);
	}
}
