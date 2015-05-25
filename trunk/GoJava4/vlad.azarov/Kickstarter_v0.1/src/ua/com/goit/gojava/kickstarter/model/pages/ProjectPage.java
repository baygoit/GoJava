package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.ProjectsViewer;

public class ProjectPage implements Page {
	
	private PageId id;
    private ProjectsViewer projectsViewer;
    private Project project;

    public ProjectPage(Printer printer, Project project) {
    	id = PageId.CATEGORY;
    	projectsViewer = new ProjectsViewer(printer);
    	this.project = project;
	}

	@Override
	public void showPage() {
		
	}

	@Override
	public PageId getPageId() {
		// TODO Auto-generated method stub
		return null;
	}

}
