package ua.goit.goitjava.kickstarter;

import java.util.ArrayList;

public class Projects {
	
	private ArrayList<Project> projects = new ArrayList<>();
	
	public ArrayList<Project> getProjectsByCategory(Category category) {
		ArrayList<Project> projectsByCategory = new ArrayList<Project>();
		
		for(Project project: projects)
		{
			if(project.getCategory() == category)
			{
				projectsByCategory.add(project);
			}
		}
		return projectsByCategory;
	}
	
	public void addProject(Project project){
		projects.add(project);
	}
	
	public int getSize(){
		return projects.size();
	}

}
