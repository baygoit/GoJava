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
	
	public void addProject(String category, String title, String details){
		model.addProject(category, title, details);
	}
	
	public ArrayList<ProjectInfo> getProjectList(){
		return model.getProjectList();
	}
	
	public ProjectInfo getProjectDetails(int id){
		return model.getProjectDetails(id);
	}
	
	public ArrayList<ProjectInfo> getProjectListFromCategory(String categoryName) {
		ArrayList<ProjectInfo> answer= new ArrayList<ProjectInfo>();
		for ( int i=0; i<model.getProjectList().size(); i++ ){
			ProjectInfo projectInfo = model.getProjectDetails(i);
			if (projectInfo.get("Category").equals(categoryName)){
				answer.add(projectInfo);
			}
	}
		return answer;
	}


	public void printProjectsList() {
		view.printProjectsList(this.getProjectList());
	}
	
	public void printProjectDetails(int id) {
		view.printProjectDetails(this.getProjectDetails(id));
	}
	
	

}
