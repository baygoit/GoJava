package home.GoJava2.DataBase;
import java.util.List;

import home.GoJava2.Content.Category;
import home.GoJava2.Content.Project;

public class ProjectStorage {
	private List<Project> projects;
	
	public ProjectStorage(List<Project> projects) {
		this.projects = projects;
		projects.add(new Project("AAAA", "EEEE", 23.3, 21));
	}
		
	public List<Project> getSpecificProjects(Category category) {
		
		for(Project p: projects) {
			if(p.getCategory().equals(category)) {
				return projects;
			}
		}
		return null;
	}
}