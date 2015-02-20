package ua.com.scread.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.Project;

public class InMemoryProjects implements Projects {
	private List<Project> projects;
	
	public InMemoryProjects() {
		projects = new ArrayList<Project>();
	}

	@Override
    public List<Project> getProjects() {
		return projects;
	}

	@Override
    public List<Project> getProjects(Category category) {
		List<Project> result = new ArrayList<Project>();
        for (int index = 0; index < projects.size(); index ++) {
                Project project = projects.get(index);
                if (project.getCategory().equals(category)) {
                        result.add(project);
                }
        }
        return result;
	}

	@Override
    public void add(Project project) {
		projects.add(project);		
	}

	@Override
    public int size() {
	    return projects.size();
	}
    
}
