package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseOfProjects {

	private List<Project> projects = new ArrayList<>();

	public List<Project> selectCategory(String type) {
		List<Project> categoryProjects = new ArrayList<>();
		for (Project project : projects) {
			if (type.equals(project.getCategory())) {
				categoryProjects.add(project);
			}
		}
		return categoryProjects;
	}

	public List<String> findProfile(int id) {
		List<String> result = new ArrayList<>();
		for (Project p : projects) {
			if (id == p.getId()) {
				result = p.openProfile(id);
			}
		}
		return result;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
