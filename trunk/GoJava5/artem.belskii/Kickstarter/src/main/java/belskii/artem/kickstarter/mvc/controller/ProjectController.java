
package belskii.artem.kickstarter.mvc.controller; 

import java.util.HashMap;
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
	
	public HashMap<Long, Project> getProjectList(){
		return model.getProjectList();
	}
	
	public Project printProjectDetails(int id){
		return view.printProjectDetails(model.getProjectDetails(id));
	}
	
	public HashMap<Long, Project> getProjectFromCategory(int id){
		return model.getProjectFromCategory(id);
	}
	
	public Project getProjectId(Long id){
		return model.getProjectList().get(id);
	}
	
	
//	public void addPayment(int projectId){
//		for (Map.Entry entry : model.getProjectDetails(projectId).getPaymetVariants().entrySet()) {
//		    System.out.println("Payment Value: " + entry.getKey() + " Bonus: "+ entry.getValue());
//		}
//		model.getProjectDetails(projectId).updateBalance(in.nextLong());
//		System.out.println("Thanks! Current balance:" +model.getProjectDetails(projectId).getBalance());
//	}
//
//	public void addCustomPayment (int projectId) {
//		System.out.println("Please enter cardholder name:");
//		String cardHolderName = in.nextLine();
//		System.out.println("Please enter card number:");
//		String cardNumber = in.nextLine();
//		System.out.println("Please enter amount:");
//		Long amount = in.nextLong();
//		model.getProjectDetails(projectId).updateBalance(amount);
//		System.out.println("Thanks, "+cardHolderName+"! Current balance:" +model.getProjectDetails(projectId).getBalance());
//	}
//
//	public void asqAQuestion(int projectId) {
//		System.out.println("Put your question on next line:");
//		model.getProjectDetails(projectId).asqAQuestion(in.nextLine());
//		System.out.println("Thanks for your question! Put 0 for retrun to project details.");
//	}
}
