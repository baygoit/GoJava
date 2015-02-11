package myRealization;

import java.util.ArrayList;
import java.util.List;

public class Projects {
	private List<Project> projects = new ArrayList<>();
	private List<Project> categoryProjects = new ArrayList<>();
	private List<String> projectData = new ArrayList<>();
	private List<String> projectAllInfo = new ArrayList<>();
	
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
	
	public ArrayList<String> giveAllInfo(Project project){
		projectAllInfo.clear();
		projectAllInfo.add(project.getHistory());
		projectAllInfo.add(project.getVideoLink());
		projectAllInfo.add(project.getQuestion());	
		
		return (ArrayList<String>) projectAllInfo;
 	}
	
	public String readProject(int index){
		return projectData.get(index);
	}
	
	public Project readObject(int index){
		return categoryProjects.get(index);
	}
	
	public int getLenth(){
		return categoryProjects.size();
	}
}
