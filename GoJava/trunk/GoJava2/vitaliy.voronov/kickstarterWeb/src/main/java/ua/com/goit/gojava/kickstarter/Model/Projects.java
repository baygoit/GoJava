package ua.com.goit.gojava.kickstarter.Model;

import java.util.List;

public interface Projects {
	
	public List<Project> getProjects(Category category);
	public Project getProject(int id);
	public void addProject(Project project);
	
}
