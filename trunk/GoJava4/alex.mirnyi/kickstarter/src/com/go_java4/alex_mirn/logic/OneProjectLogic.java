package com.go_java4.alex_mirn.logic;

import java.io.IOException;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.logic.ILogic;
import com.go_java4.alex_mirn.input_output.pages.OneProjectPage;


public class OneProjectLogic implements ILogic {
	private Repository repository;

	public OneProjectLogic(Repository repository) {
		this.repository = repository;
	}

	
	public ProjectsContainer getProjects() {
		return repository.projects;
	}

	public Category getCategory(int index1) {
		Category category = repository.categories.get(index1);
		return category;
	}
	
	public int getSize() {
		return repository.projects.size();
	}

	public String getIndex(int index1) {
		String index = repository.projects.get(index1).toString();
		return index;
	}
	
	public Project getProject(int index) {
		Project project = repository.projects.get(index);
		return project;
	}
	
	public String getProjectFullInfo(int index) {
		Project project = repository.projects.get(index);
		return project.fullInfo();
	}
}
