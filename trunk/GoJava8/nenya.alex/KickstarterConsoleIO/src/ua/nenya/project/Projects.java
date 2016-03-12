package ua.nenya.project;

import java.util.ArrayList;
import java.util.List;

public class Projects {
	private List<Project> projects = new ArrayList<>();

	public List<Project> getProjects() {
		return projects;
	}
	
	public List<Project> getProjects(Category category) {
		List<Project> list = new ArrayList<>();
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			if (project.getCategory().getName().equals(category.getName())){
				list.add(project);
			}
		}

		return list;
	}

}
