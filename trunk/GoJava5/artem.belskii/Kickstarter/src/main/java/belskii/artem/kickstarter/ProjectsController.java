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
	
	public String[] getProjectListFromCategory(String categoryName) {
		String [] answer;
		if (model.getProjectList().size()>0){
			answer = new String[model.getProjectList().size()];
		} else {
			answer = new String[0];
			answer[0]="";
		}

		for ( int i=0; i<model.getProjectList().size(); i++ ){
			ProjectInfo projectInfo = model.getProjectDetails(i);
			if (projectInfo.get("Category").equals(categoryName)){
				answer[i]=projectInfo.get("Title");
				//System.out.println(i+ " "+projectInfo.get("Title"));
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
