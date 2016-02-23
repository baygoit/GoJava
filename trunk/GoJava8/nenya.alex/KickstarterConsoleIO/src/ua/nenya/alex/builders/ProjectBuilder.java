package ua.nenya.alex.builders;

import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;

public class ProjectBuilder {

	private Project project;

	public Project getProject() {
		return project;
	}

	public ProjectBuilder() {
		project = new Project();
	}

	
	public ProjectBuilder add(String name, String description, int allAmount,
			int availableAmount, int daysRemain, Category category) {
		Project newProject = new Project(name, description, allAmount, availableAmount,
				daysRemain);
		project.getProjectsList().add(newProject);
		newProject.setCategory(category);
		return this;
	}

}
