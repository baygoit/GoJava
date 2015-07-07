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

	public void addProject(String category, String title, String details) {
		model.addProject(category, title, details);
	}

	public ArrayList<ProjectInfo> getProjectList() {
		return model.getProjectList();
	}

	public String getProjectDetails(String selectedProject) {
		String answer="";
		for (int i = 0; i < model.getProjectList().size(); i++) {
			ProjectInfo projectInfo = model.getProjectDetails(i);
			if (projectInfo.get("Title").equals(selectedProject)) {
				answer = projectInfo.get("Details");
			}
		}
		return answer;
	}

	public String[] getProjectListFromCategory(String categoryName) {
		//can't use String [] with necessary length, so use ArrayList as tmp storage
		ArrayList answerArrayList = new ArrayList();
		for (int i = 0; i < model.getProjectList().size(); i++) {
			ProjectInfo projectInfo = model.getProjectDetails(i);
			if (projectInfo.get("Category").equals(categoryName)) {
				answerArrayList.add(projectInfo.get("Title"));
			}
		}
		int arrayAnswerSize=1;
		if (answerArrayList.size()>1){
			arrayAnswerSize=answerArrayList.size();
		}
		String [] answer = new String[arrayAnswerSize];
		for (int i=0; i<answerArrayList.size();i++){
			answer[i]=answerArrayList.get(i).toString();			
		} 
		return answer;
	}

	public void printProjectsList() {
		view.printProjectsList(this.getProjectList());
	}

	public void printProjectDetails(String title) {
		view.printProjectDetails(this.getProjectDetails(title));
	}

}
