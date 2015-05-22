package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.ProjectsPage;

public class ProjectsController {

	private ProjectsPage projectsPage;
	private ProjectsRepository projectsRepository;

	public ProjectsController(Printer printer) {
		projectsRepository = new ProjectsRepository();
		projectsPage = new ProjectsPage(printer);
	}

	public ArrayList<Project> getProjectsFromCategory(Category category) {
		return projectsRepository.getProjectsFromCategory(category);
	}

	public void showProjectInfo(Project project) {
		projectsPage.showProjectInfo(project);
	}

	public void showProjectMenu(Project project) {
		projectsPage.showProjectMenu(project);
	}

	public void showProjectsOfCategory(Category category) {
		projectsPage.showProjectsOfCategory(category,
				getProjectsFromCategory(category));
	}
}
