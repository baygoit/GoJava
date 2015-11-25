package ua.com.goit.gojava7.kickstarter.domain;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private final int id;
	private String name;
	//private Set<Project> projects;

	public Category(String name, int categoryId) {
		setName(name);
		this.id = categoryId;
		//projects = new HashSet<Project>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public Set<Project> getProjects() {
		return projects;
	}
*/
	public int getId() {
		return id;
	}

	/*public void addProject(Project project) {
		projects.add(project);
	}

	public Project getProject(int userChoise) {
		Object[] projectsw = projects.toArray();
		return (Project) projectsw[userChoise];
	}

	public int projectsSize() {
		return projects.size();
	}*/

}
