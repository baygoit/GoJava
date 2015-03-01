package ua.goit.goitjava.kickstarterInMemory;

import java.util.ArrayList;

import ua.goit.goitjava.kickstarter.Category;
import ua.goit.goitjava.kickstarter.Project;

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
