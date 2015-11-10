package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {

	private String name;
	private List<Project> projects = new ArrayList<Project>();

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void add(Project project) {
		projects.add(project);
	}

	public List<Project> get() {
		return Collections.unmodifiableList(projects);
	}

	public Project get(int index) {
		return projects.get(index);
	}

	public Integer size() {
		return projects.size();
	}
}