package ua.nenya.alex.builders;

import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.project.Projects;

public class ProjectBuilder {

	private Projects projects;

	public Projects getProject() {
		return projects;
	}

	public ProjectBuilder() {
		projects = new Projects();
	}

	
	public ProjectBuilder add(String name, String description, int allAmount,
			int availableAmount, int daysRemain, Category category) {
		Project newProject = new Project(name, description, allAmount, availableAmount,
				daysRemain);
		projects.getProjects().add(newProject);
		newProject.setCategory(category);
		return this;
	}

}
