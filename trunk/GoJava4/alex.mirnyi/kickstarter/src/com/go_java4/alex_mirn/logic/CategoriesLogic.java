package com.go_java4.alex_mirn.logic;

import java.io.IOException;


import com.go_java4.alex_mirn.Repository;
//import com.go_java4.alex_mirn.data.Category;
//import com.go_java4.alex_mirn.data.Project;
//import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
//import com.go_java4.alex_mirn.input_output.pages.CategoriesPage;
//import com.go_java4.alex_mirn.input_output.pages.OneProjectPage;
//import com.go_java4.alex_mirn.input_output.pages.ProjectsPage;
import com.go_java4.alex_mirn.logic.ILogic;

public class CategoriesLogic implements ILogic{
	private Repository repository;


	public CategoriesLogic(Repository repository) {
		this.repository = repository;
	}
	
	public int getSize() {
		return repository.categories.size();
	}

	public String getIndex(int index1) {
		String index = getCategories().get(index1).toString();
		return index;
	}
	
	public String getQuote() {
		String quote = getQuotes().getRandom().toString();
		return quote;
	}

	public QuotesContainer getQuotes() {
		return repository.quotes;
	}

	public void setQuotes(QuotesContainer quotes) {
		repository.quotes = quotes;
	}

	public ProjectsContainer getProjects() {
		return repository.projects;
	}

	public void setProjects(ProjectsContainer projects) {
		repository.projects = projects;
	}

	public CategoriesContainer getCategories() {
		return repository.categories;
	}

}

