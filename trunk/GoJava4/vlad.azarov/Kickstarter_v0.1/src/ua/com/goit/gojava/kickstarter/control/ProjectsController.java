package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.ProjectsViewer;

public class ProjectsController {

	private ProjectsViewer projectsViewer;
	private ProjectsRepository projectsRepository;

	public ProjectsController(Printer printer) {
		projectsRepository = new ProjectsRepository();
		projectsViewer = new ProjectsViewer(printer);
	}

	public ArrayList<Project> getProjectsFromCategory(Category category) {
		return projectsRepository.getProjectsFromCategory(category);
	}

	public void showProjectInfo(Project project) {
		projectsViewer.showProjectInfo(project);
	}

	public void showProjectMenu(Project project) {
		projectsViewer.showProjectMenu(project);
	}

	public void showProjectsOfCategory(Category category) {
		projectsViewer.showProjectsOfCategory(category,
				getProjectsFromCategory(category));
	}
}
