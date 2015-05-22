package com.go_java4.alex_mirn.logic;

import java.io.IOException;

import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.input_output.InputData;
import com.go_java4.alex_mirn.input_output.pages.OneProjectPage;
import com.go_java4.alex_mirn.input_output.printers.ConsolePrinter;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;

public class OneProjectLogic {
	private QuotesContainer quotes;
	private CategoriesContainer categories;
	private ProjectsContainer projects;
	private Printer printer;
	private Reader reader;

	public OneProjectLogic(Printer printer, Reader reader,
			QuotesContainer quotes, CategoriesContainer categories,
			ProjectsContainer projects) {
		this.printer = printer;
		this.reader = reader;
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}
	
	public void run(int categoryChoice, int projectChoice) throws IOException {
		OneProjectPage oneProject = new OneProjectPage(printer, reader);
		for (int index = 0; index < getProjects().size(); index++) {
			if (projectChoice == 0) {
				oneProject.showFooter();
				ProjectsLogic projectsLogic = new ProjectsLogic(new ConsolePrinter(),
						new ConsoleReader(), quotes, categories, projects); 
				projectsLogic.run(categoryChoice);
			} else if (categoryChoice == getProjects().get(index)
					.getCategory().getId()
					&& projectChoice == getProjects().get(index)
							.getProjectId()) {
				oneProject.showFooter();
				oneProject.addData(getProjects().get(index).fullInfo());
				oneProject.showData();
				oneProject.showExit();
				oneProject.showFooter();
				int goToProjectLIst = new InputData(printer, reader)
						.inputData(1);
				if (goToProjectLIst == 0) {
					ProjectsLogic projectsLogic = new ProjectsLogic(new ConsolePrinter(),
							new ConsoleReader(), quotes, categories, projects); 
					projectsLogic.run(categoryChoice);
				} else {
					oneProject.showError();
					oneProject.showFooter();
					OneProjectLogic oneProjectLogic = new OneProjectLogic(new ConsolePrinter(),
							new ConsoleReader(), quotes, categories, projects); 
					oneProjectLogic.run(categoryChoice, projectChoice);
				}
		
			}
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