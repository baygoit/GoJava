package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectStorage {
	private List<Project> projects = new ArrayList<>();

	public List<Project> getProgects(Category category) {
		List<Project> projectsOfCategory = new ArrayList<>();

		for (Project project : projects) {
			if (project.getCategorie() == category) {
				projectsOfCategory.add(project);
			}
		}

		return Collections.unmodifiableList(projectsOfCategory);
	}

	public void add(Project progect) {
		projects.add(progect);
	}

/*	public int size(Category category) {
		return getProgects(category).size();
	}*/
}
