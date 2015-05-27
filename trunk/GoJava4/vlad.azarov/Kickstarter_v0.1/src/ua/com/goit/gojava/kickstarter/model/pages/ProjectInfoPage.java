package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.ProjectsViewer;

public class ProjectInfoPage implements Page {

    private PageId id;
    private ProjectsViewer projectsViewer;
    private Project project;
    private Category category;

    public ProjectInfoPage(Printer printer, Project project, Category category) {
	id = PageId.PROJECT_INFO;
	projectsViewer = new ProjectsViewer(printer);
	this.project = project;
	this.category = category;
    }

    @Override
    public void showPage() {
	projectsViewer.showProjectInfo(project, category);
    }

    @Override
    public PageId getPageId() {
	return id;
    }

}
