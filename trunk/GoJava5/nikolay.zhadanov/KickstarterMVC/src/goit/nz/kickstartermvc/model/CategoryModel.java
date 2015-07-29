package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.storage.DataStorage;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {

	private List<Project> categoryProjects;
	private DataStorage storage;

	public CategoryModel(DataStorage storage) {
		this.storage = storage;
	}

	public void update(String categoryName) {
		categoryProjects = new ArrayList<>();
		categoryProjects.addAll(storage.getProjects(categoryName));
	}

	public List<Project> getProjects() {
		return categoryProjects;
	}

	public int size() {
		return categoryProjects.size();
	}

}
