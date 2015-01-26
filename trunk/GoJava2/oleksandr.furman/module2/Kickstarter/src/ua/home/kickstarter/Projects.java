package ua.home.kickstarter;

import java.util.ArrayList;

public class Projects {
	private ArrayList<Project> projects = new ArrayList<Project>();

	public void add(Project project) {
		projects.add(project);
	}

	public ArrayList<Project> getProjects(Category category) {
		ArrayList<Project> result = new ArrayList<Project>();

		for (int index = 0; index < projects.size(); index++) {
			Project project = projects.get(index);
			if (projects.get(index).getCategory().equals(category)) {
				result.add(project);

			}
		}
		return result;
	}

	public ArrayList<Project> getFullProject(int projectIndex, Category category) {
		ArrayList<Project> result = new ArrayList<Project>();
		result.add(getProjects(category).get(projectIndex - 1));
		return result;
	}

	public Project getName(int index, Category category) {
		ArrayList<Project> result = new ArrayList<Project>();
		if (getProjects(category).get(index - 1).getCategory().equals(category)) {
			result.add(getProjects(category).get(index - 1));
		}
		return result.get(0);
	}

}
