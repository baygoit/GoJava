package ua.com.goit.gojava7.kickstarter.domain;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private String name;
	private Set<Project> projects = new HashSet<>();

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
