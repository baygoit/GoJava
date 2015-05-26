package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;

import com.go_java4.alex_mirn.Repository;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.input_output.InputData;
import com.go_java4.alex_mirn.input_output.pages.CategoriesPage;
import com.go_java4.alex_mirn.input_output.printers.ConsolePrinter;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.logic.OneProjectLogic;
import com.go_java4.alex_mirn.logic.ProjectsLogic;

public class OneProjectPage implements IPage{
	private Printer printer;
	private Reader reader;
	private OneProjectLogic oneProjectLogic;
	private Repository repository;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;

	public OneProjectPage(Printer printer, Reader reader, OneProjectLogic oneProjectLogic, Repository repository) {
		this.printer = printer;
		this.reader = reader;
		this.oneProjectLogic = oneProjectLogic;
		this.repository = repository;
		header = "You have chosen ";
		data = "";
		footer = "---------------";
		exit = "To go back to the list of projects press \"0\"";
		error = "Invalid input number!!! Try again";
	}
	
	public void run(){}
	public int makeChoice(){
		return 0;
	}
	public void goBack(){}
	
	public void showHeader() {
		printer.println(header);
	}

	public void addData(Project project) {
		data += project.toString() + "\n";
	}
	
	public void addData(String project) {
		data += project + "\n";
	}

	public void showData() {
		printer.println(data);
	}

	public void showFooter() {
		printer.println(footer);
	}

	public void showExit() {
		printer.println(exit);
	}

	public void showError() {
		printer.println(error);
	}
	
	public void runOneProject(int categoryChoice, int projectChoice) throws IOException {
		for (int index = 0; index < oneProjectLogic.getSize(); index++) {
			if (projectChoice == 0) {
				showFooter();
				ProjectsLogic projectsLogic = new ProjectsLogic(repository); 
				ProjectsPage projectsPage = new ProjectsPage(new ConsolePrinter(),
						new ConsoleReader(), projectsLogic, repository);
				projectsPage.runProjects(categoryChoice);
			} else if (categoryChoice == oneProjectLogic.getProject(index).getCategory().getId()
					&& projectChoice == oneProjectLogic.getProject(index).getProjectId()) {
				showFooter();
				addData(oneProjectLogic.getProjectFullInfo(index));
				showData();
				showExit();
				showFooter();
				int goToProjectLIst = new InputData(printer, reader)
						.inputData(1);
				if (goToProjectLIst == 0) {
					showFooter();
					ProjectsLogic projectsLogic = new ProjectsLogic(repository); 
					ProjectsPage projectsPage = new ProjectsPage(new ConsolePrinter(),
							new ConsoleReader(), projectsLogic, repository);
					projectsPage.runProjects(categoryChoice);
				} else {
					showError();
					showFooter();
					OneProjectLogic oneProjectLogic = new OneProjectLogic(repository); 
					OneProjectPage oneProjectPage = new OneProjectPage(new ConsolePrinter(),
							new ConsoleReader(), oneProjectLogic, repository);
					oneProjectPage.runOneProject(categoryChoice, projectChoice);
				}
		
			}
		}
	}
}
