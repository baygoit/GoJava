
package belskii.artem.kickstarter.mvc.controller;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	//public void printProjectList(){
	//	view.printProjectList();
	//}
	
	public Project printProjectDetails(int id){
		return view.printProjectDetails(model.getProjectDetails(id));
	}
	
	public ArrayList<Project> getProjectFromCategory(int id){
		return model.getProjectFromCategory(id);
	}

	public void addPayment (int projectId) {
		System.out.println("Please enter cardholder name:");
		Scanner in = new Scanner(System.in);
		String cardHolderName = in.nextLine();
		System.out.println("Please enter card number:");
		String cardNumber = in.nextLine();
		System.out.println("Please enter amount:");
		Long amount = in.nextLong();
		model.getProjectDetails(projectId).updateBalance(amount);
		System.out.println("Thanks, "+cardHolderName+"! Current balance:" +model.getProjectDetails(projectId).getBalance());
	}
}
