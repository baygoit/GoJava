package com.go_java4.alex_mirn;

import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;

public class Repository {
	public QuotesContainer quotes;
	public CategoriesContainer categories;
	public ProjectsContainer projects;
	
	public Repository(QuotesContainer quotes, CategoriesContainer categories,
			ProjectsContainer projects) {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}
}
