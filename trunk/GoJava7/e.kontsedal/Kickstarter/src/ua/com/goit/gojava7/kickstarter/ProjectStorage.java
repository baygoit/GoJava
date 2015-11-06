package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectStorage {
	private static final Map<Project, Integer> PROJECTS = new HashMap<>();

	public List<Project> getAllProjectsInCategory(Integer numberOfCategory) {
		List<Project> projectsInCategory = new ArrayList<>();
		for (Map.Entry<Project, Integer> project : PROJECTS.entrySet()) {
			if (project.getValue() == numberOfCategory) {
				projectsInCategory.add(project.getKey());
			}
		}
		return projectsInCategory;
	}

	public void setProject(Project project, int idCategory) {
		PROJECTS.put(project, idCategory);
	}

}
