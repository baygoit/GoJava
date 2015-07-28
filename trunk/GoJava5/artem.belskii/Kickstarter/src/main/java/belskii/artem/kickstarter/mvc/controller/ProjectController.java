
package belskii.artem.kickstarter.mvc.controller;

import java.util.ArrayList;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;
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
	
	public void printProjectDetails(int id){
		view.printProjectDetails(id);
	}
}
