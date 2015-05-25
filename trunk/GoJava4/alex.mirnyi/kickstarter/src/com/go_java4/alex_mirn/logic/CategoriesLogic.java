package com.go_java4.alex_mirn.logic;

import java.io.IOException;

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
	private QuotesContainer quotes;
	private CategoriesContainer categories;
	private ProjectsContainer projects;


	public CategoriesLogic(QuotesContainer quotes,
			CategoriesContainer categories, ProjectsContainer projects) {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}
	
	public int getSize() {
		return categories.size();
	}

	public String getIndex(int index1) {
		String index = categories.get(index1).toString();
		return index;
	}
	
	public String getQuote() {
		String quote = quotes.getRandom().toString();
		return quote;
	}
}

