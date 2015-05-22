package com.go_java4.alex_mirn.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.input_output.InputData;
import com.go_java4.alex_mirn.input_output.printers.ConsolePrinter;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.input_output.pages.ProjectsPage;

public class ProjectsLogic {
	private QuotesContainer quotes;
	private CategoriesContainer categories;
	private ProjectsContainer projects;
	private Printer printer;
	private Reader reader;

	public ProjectsLogic(Printer printer, Reader reader,
			QuotesContainer quotes, CategoriesContainer categories,
			ProjectsContainer projects) {
		this.printer = printer;
		this.reader = reader;
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}

	public void run(int categoryChoice) throws IOException {
		ProjectsPage projectsPage = new ProjectsPage(printer, reader);
		projectsPage.addHeader(getCategories().get(categoryChoice - 1));
		projectsPage.showHeader();
		List<Integer> inputCheck = new ArrayList<Integer>();
		for (int index = 0; index < getProjects().size(); index++) {
			if (categoryChoice == getProjects().get(index).getCategory()
					.getId()) {
				inputCheck.add(index + 1);
				projectsPage.addData(getProjects().get(index));
			}
		}
		projectsPage.showData();
		projectsPage.showFooter();
		int projectChoice = new InputData(printer, reader).inputData(this
				.getProjects().size());
		if (projectChoice == 0) {
			projectsPage.showFooter();
			CategoriesLogic categoriesLogic = new CategoriesLogic(new ConsolePrinter(),
					new ConsoleReader(), quotes, categories, projects); 
			categoriesLogic.run();
		} else if (inputCheck.contains(projectChoice)) {
			OneProjectLogic oneProjectLogic = new OneProjectLogic(new ConsolePrinter(),
					new ConsoleReader(), quotes, categories, projects); 
			oneProjectLogic.run(categoryChoice, projectChoice);
		} else {
			projectsPage.showError();
			projectsPage.showFooter();
			ProjectsLogic projectsLogic = new ProjectsLogic(new ConsolePrinter(),
					new ConsoleReader(), quotes, categories, projects); 
			projectsLogic.run(categoryChoice);
		}
	}

	public CategoriesContainer getCategories() {
		return categories;
	}

	public void setCategories(CategoriesContainer categories) {
		this.categories = categories;
	}

	public ProjectsContainer getProjects() {
		return projects;
	}

	public void setProjects(ProjectsContainer projects) {
		this.projects = projects;
	}

}
