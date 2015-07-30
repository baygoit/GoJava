
package belskii.artem.kickstarter.mvc.controller;

import java.util.ArrayList;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.view.ProjectView;

public class ProjectController {
	private ProjectModel model;
	private ProjectView view;
	
	public ProjectController(ProjectModel model, ProjectView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addProject(Project projectDetails){
		model.addProject(projectDetails);
	}
	
	public ArrayList<Project> getProjectList(){
		return model.getProjectList();
	}
	
	public void printProjectList(){
		view.printProjectList();
	}
	
	public Project printProjectDetails(int id){
		return view.printProjectDetails(model.getProjectDetails(id));
	}
	
	public ArrayList<Project> getProjectFromCategory(int id){
		return model.getProjectFromCategory(id);
	}
}
