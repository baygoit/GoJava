package belskii.artem.kickstarter;

import java.util.ArrayList;

import belskii.artem.kickstarter.Projects.ProjectInfo;

public class ProjectsController {
	private Projects model;
	private ProjectsView view;

	public ProjectsController(Projects model, ProjectsView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addProject(String title, String details){
		model.addProject(title, details);
	}
	
	public ArrayList<ProjectInfo> getProjectList(){
		return model.getProjectList();
	}
	
	public ProjectInfo getProjectDetails(int id){
		return model.getProjectDetails(id);
	}

	public void printProjectsList() {
		view.printProjectsList(this.getProjectList());
	}
	
	public void printProjectDetails(int id) {
		view.printProjectDetails(this.getProjectDetails(id));
	}
	
	

}
