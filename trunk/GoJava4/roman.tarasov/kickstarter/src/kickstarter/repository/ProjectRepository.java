package kickstarter.repository;

import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.Project;

public class ProjectRepository {
	List<Project> projects;

	public ProjectRepository() {
		int categoryID = 5;
		projects = new ArrayList<Project>();
		Project project = new Project("Create electrobike", categoryID);
		project.description = "high efficiency";
		project.shortDescription = "short description";
		project.history = "history of bike creation";
		project.linkToVideo = "www.link.to.demo.video";
		project.pledged = 25;
		project.goal = 2000;
		project.ID = 23;
		project.investmentOptions=new String[]{"1$ - ","10$ -","40$ -"};
		project.amount=new double[] {1,10,40};
		projects.add(project);

		categoryID = 4;
		project = new Project("Paint the fence of the school", categoryID);
		project.description = "raising money for paint";
		project.investmentOptions=new String[]{"1$ - ","10$ -","40$ -"};
		project.amount=new double[] {1,10,40};
		project.ID = 8;
		projects.add(project);

	}

	public int getProjectsLength() {
		return projects.size();
	}

	public Project getProject(int index) {
		return projects.get(index);
	}

	public Project getProjectById(int ID) {
		int length = projects.size();

		for (int index = 0; index < length; index++) {
			Project currentProject = projects.get(index);
			if (currentProject.ID == ID) {
				return currentProject;
			}
		}
		return null;
	}
}
