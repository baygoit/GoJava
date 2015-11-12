package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.storage.Storage;

public class Category implements Storage {

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

	@Override
	public int size() {
		return projects.size();
	}
}