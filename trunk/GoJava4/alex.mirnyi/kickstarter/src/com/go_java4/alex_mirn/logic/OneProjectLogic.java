package com.go_java4.alex_mirn.logic;

import java.io.IOException;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.logic.ILogic;
import com.go_java4.alex_mirn.input_output.pages.OneProjectPage;


public class OneProjectLogic implements ILogic {
	private QuotesContainer quotes;
	private CategoriesContainer categories;
	private ProjectsContainer projects;

	public OneProjectLogic(QuotesContainer quotes, CategoriesContainer categories,
			ProjectsContainer projects) {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}

	
	public ProjectsContainer getProjects() {
		return projects;
	}

	public Category getCategory(int index1) {
		Category category = categories.get(index1);
		return category;
	}
	
	public int getSize() {
		return projects.size();
	}

	public String getIndex(int index1) {
		String index = projects.get(index1).toString();
		return index;
	}
	
	public Project getProject(int index) {
		Project project = projects.get(index);
		return project;
	}
	
	public String getProjectFullInfo(int index) {
		Project project = projects.get(index);
		return project.fullInfo();
	}
}

