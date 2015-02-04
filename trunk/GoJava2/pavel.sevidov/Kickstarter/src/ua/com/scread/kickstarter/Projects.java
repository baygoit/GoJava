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

	public void add(Project project) {
		projects.add(project);		
	}
	
	public int size() {
	    return projects.size();
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((projects == null) ? 0 : projects.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Projects other = (Projects) obj;
        if (projects == null) {
            if (other.projects != null)
                return false;
        } else if (!projects.equals(other.projects))
            return false;
        return true;
    }
}
