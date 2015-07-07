package belskii.artem.kickstarter;

import java.util.ArrayList;

import belskii.artem.kickstarter.Projects.ProjectInfo;

public class ProjectsView {

	public void printProjectsList(ArrayList<ProjectInfo> projectList) {
		for (int i=0; i<projectList.size(); i++){
			System.out.println(projectList.get(i).toString());
		}
	}

	public void printProjectDetails(String projectDetails) {
		System.out.println(projectDetails.toString());
	}

}
