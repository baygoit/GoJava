package myRealization;

import java.util.ArrayList;
import java.util.List;

public class Projects {
	private List<Project> projects = new ArrayList<>();
	private List<Project> categoryProjects = new ArrayList<>();
	private List<String> projectData = new ArrayList<>();
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public void chooseProjects(Category category) {
		categoryProjects.clear();
		for (Project project : projects) {
			if (project.getCategory() == category) {
				categoryProjects.add(project);
			}
		}
	}
	
	public ArrayList<String> writeProjects(){
		projectData.clear();
		for (Project project : categoryProjects){
			projectData.add(writeProject(project));
		}
		return (ArrayList<String>) projectData;
	}
	
	public String writeProject(Project project) {
		return " Name - " + project.getProjectName() + ", Description - "
				+ project.getDescription() + ", Money we need - "
				+ project.getMoneyNeed() + ", Money we have - "
				+ project.getMoneyHas() + ", Days left - "
				+ project.getDaysLeft();
	}
	
	public String readProject(int index){
		return projectData.get(index);
	}
	
}
