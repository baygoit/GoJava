package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Projects {
	private List<Project> projects;
	
	public Projects() {
		projects = new ArrayList<Project>();
	}

	public List<Project> getProjects() {
		return projects;
	}
	
	public ArrayList<Project> getProjects(Category category) {
		ArrayList<Project> result = new ArrayList<Project>();
        for (int index = 0; index < projects.size(); index ++) {
                Project project = projects.get(index);
                if (project.getCategory().equals(category)) {
                        result.add(project);
                }
        }
        return result;
	}

	public void add(Project project) {
		projects.add(project);		
	}
}
