package Kickstarter;

import java.io.*;
import java.util.*;

import Data.Quote;
import Data.Category;
import Data.Project;
import DataContainers.CategoriesContainer;
import DataContainers.ProjectsContainer;
import DataContainers.QuotesContainer;
import InputOutput.pages.CategoriesPage;
import InputOutput.pages.OneProjectPage;
import InputOutput.pages.ProjectsPage;
import InputOutput.printers.ConsolePrinter;
import InputOutput.printers.Printer;
import InputOutput.readers.ConsoleReader;
import InputOutput.readers.Reader;
import InputOutput.InputData;

public class Kickstarter {
	private QuotesContainer quotes;
	private CategoriesContainer categories;
	private ProjectsContainer projects;
	private Printer printer;
	private Reader reader;
	
	public Kickstarter(Printer printer, Reader reader, 
			           QuotesContainer quotes, CategoriesContainer categories, 
			           ProjectsContainer projects) {
		this.printer = printer;
		this.reader = reader;
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
	}
	
	public void run() throws IOException {
		showCategories();
	}
	
	public void showCategories() throws IOException {
		CategoriesPage categoriesPage = new CategoriesPage(printer, reader);
		
		Quote quote = this.quotes.getRandom();
		categoriesPage.addQuote(quote);
		categoriesPage.showHeader();
	
		for (int index = 0; index < this.getCategories().size(); index++) {
			categoriesPage.addData(index, this.getCategories().get(index));
		}
		categoriesPage.showData();
		categoriesPage.showFooter();
		
		int categoryChoice = new InputData(printer, reader).inputData(this.getCategories().size());
		if ( categoryChoice == 0 ) {
			categoriesPage.showExit();
		} else {
			showProjects(categoryChoice);
		}
	}
	
	public void showProjects(int categoryChoice) throws IOException {
		ProjectsPage projectsPage = new ProjectsPage(printer, reader);
		projectsPage.addHeader(getCategories().get(categoryChoice- 1));
		projectsPage.showHeader();
		List<Integer> inputCheck = new ArrayList<Integer>();
		for (int index = 0; index < this.getProjects().size(); index++) {
			if (categoryChoice == this.getProjects().get(index).getCategory().getId()) {
				inputCheck.add(index+1);
				projectsPage.addData(this.getProjects().get(index));
			}
		}
		projectsPage.showData();
		projectsPage.showFooter();
		int projectChoice = new InputData(printer, reader).inputData(this.getProjects().size());
		if (projectChoice == 0 ) {
			projectsPage.showFooter();
			showCategories();	
		} else if (inputCheck.contains(projectChoice)) {
			this.oneProjectChoice(categoryChoice, projectChoice);
		} else { 
			projectsPage.showError();
			showProjects(categoryChoice);
		}
	}
	
	public void oneProjectChoice(int categoryChoice, int projectChoice) throws IOException {
		OneProjectPage oneProject = new OneProjectPage(printer, reader);
		for (int index = 0; index < this.getProjects().size(); index++) {
			if ( projectChoice == 0 ) {
				oneProject.showFooter();
				showProjects(categoryChoice);
			} else if (categoryChoice == this.getProjects().get(index).getCategory().getId() &&
					   projectChoice == this.getProjects().get(index).getProjectId()) {
				oneProject.showFooter();
				oneProject.addData(this.getProjects().get(index).fullInfo());
				oneProject.showData();
				oneProject.showExit();
				oneProject.showFooter();
				int goToProjectLIst = new InputData(printer, reader).inputData(1);
				if (goToProjectLIst == 0) {
					showProjects(categoryChoice);
				} else {
					oneProject.showError();
					oneProjectChoice(categoryChoice, projectChoice);
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
