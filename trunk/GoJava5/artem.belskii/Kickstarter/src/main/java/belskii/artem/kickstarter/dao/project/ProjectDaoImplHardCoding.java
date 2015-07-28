package belskii.artem.kickstarter.dao.project;

import java.util.ArrayList;

public class ProjectDaoImplHardCoding implements ProjectDao {
	private ArrayList<Project> projects;
	private static int index=0;

	public void addProject(Project projectDetails) {
		projects.add(index,projectDetails);
		index++;
		System.out.println("index: "+index);
		
	}

	public ArrayList<Project> getProjectList() {
		return projects;
	}

	public Project getProjectDetails(int id) {
		return projects.get(id);
	}
	
	
}
