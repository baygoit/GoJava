package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.ProjectsPage;

public class ProjectsControl {

    private ProjectsPage projectsPage;
    private ProjectsRepository projectsRepository;
    private InputControl inputControl;

    public ProjectsControl(Printer printer) {
	projectsRepository = new ProjectsRepository();
	projectsPage = new ProjectsPage(printer);
    }

    public ArrayList<Project> getProjectsByCategory(Category category) {
	return projectsRepository.getProjectsByCategory(category);
    }
    
    public void showProjectInfo(Project project) {
	projectsPage.showProjectInfo(project);
    }

    public void showProjectMenu(Project project) {
	projectsPage.showProjectMenu(project, inputControl.readUserInput());
    }
    
    public void showProjectsOfCategory(Category category) {
	projectsPage.showProjectsOfCategory(category, getProjectsByCategory(category));
    }
}
