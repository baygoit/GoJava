package ua.com.goit.gojava7.kickstarter.domain;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private Long id;
	private String name;
	private Set<Project> projects = new HashSet<Project>();

	public Category() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
