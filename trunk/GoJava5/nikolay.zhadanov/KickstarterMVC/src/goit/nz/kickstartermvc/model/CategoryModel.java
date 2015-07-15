package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.DataStorage;
import goit.nz.kickstartermvc.dao.Project;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {

	private String chosenCategoryName;
	private List<Project> categoryProjects;
	private DataStorage storage;

	public CategoryModel(DataStorage storage) {
		this.storage = storage;
	}

	public void update(String categoryName) {
		this.chosenCategoryName = categoryName;
		categoryProjects = new ArrayList<>();
		for (Project project : storage.getProjects()) {
			if (project.getCategory().getName().equals(chosenCategoryName)) {
				categoryProjects.add(project);
			}
		}
	}

	public List<Project> getProjects() {
		return categoryProjects;
	}

	public String getCategoryName() {
		return chosenCategoryName;
	}

	public int size() {
		return categoryProjects.size();
	}

	public Project getChosenProject(int index) {
		return categoryProjects.get(index - 1);
	}
}
