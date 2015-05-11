package DataContainers;

import java.util.ArrayList;
import java.util.List;

import Data.Project;

public class ProjectsContainer {
public List<Project> categories;
	
	public ProjectsContainer() {
		categories = new ArrayList<Project>();
	}
	
	public Project get(int index) throws IndexOutOfBoundsException {
		return categories.get(index);
	}
	
	public int size() {
		return categories.size();
	}
	
	public void add(Project project) {
		categories.add(project);
	}
	
	public List<Project> getProjects() {
		return categories;
	}
}
