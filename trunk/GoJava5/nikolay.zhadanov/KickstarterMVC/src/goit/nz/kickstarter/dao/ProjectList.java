package goit.nz.kickstarter.dao;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project> projects;
	private ArrayList<String> fields;
	private Category category;
	
	public ProjectList(Category category) {
		projects = new ArrayList<Project>();
		this.category = category;
		fields = new ArrayList<String>();
		fields.add("");
		fields.add("Description: ");
		fields.add("Required Amount: ");
		fields.add("Collected Amount: ");
		fields.add("Days Left: ");
	}
	
	public void add(Project project) {
		projects.add(project);
	}
	
	public int size() {
		return projects.size();
	}
	
	public Category getCategory() {
		return category;
	}
	
	public Project getProject(int index) {
		return projects.get(index);
	}
	
	public ArrayList<String> getFields() {
		return fields;
	}
}
