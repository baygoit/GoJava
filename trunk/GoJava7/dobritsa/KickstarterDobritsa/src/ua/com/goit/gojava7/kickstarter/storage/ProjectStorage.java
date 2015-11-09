package ua.com.goit.gojava7.kickstarter.storage;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectStorage {
	
	private List<Project> projects = new ArrayList<Project>();
	
	public void add(Project project) {
		projects.add(project);		
	}
	
	public Project get(Integer index) {
		return projects.get(index);		
	}		
	
	public List<Project> get() {
		return projects;		
	}	
	
	public Integer size() {
		return projects.size();		
	}	
}
