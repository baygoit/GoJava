package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;

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

public class OneProjectPage {
	private Printer printer;
	private Reader reader;
	private OneProjectLogic oneProjectLogic;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;

	public OneProjectPage(Printer printer, Reader reader, OneProjectLogic oneProjectLogic) {
		this.printer = printer;
		this.reader = reader;
		this.oneProjectLogic = oneProjectLogic;
		header = "You have chosen ";
		data = "";
		footer = "---------------";
		exit = "To go back to the list of projects press \"0\"";
		error = "Invalid input number!!! Try again";
	}

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
	
	public int run(int categoryChoice, int projectChoice) throws IOException {
//		OneProjectPage oneProject = new OneProjectPage(printer, reader);
		int goToProjectLIst = 0;
		for (int index = 0; index < oneProjectLogic.getSize(); index++) {
			if (projectChoice == 0) {
				showFooter();
//				ProjectsLogic projectsLogic = new ProjectsLogic(new ConsolePrinter(),
//						new ConsoleReader(), quotes, categories, projects); 
//				projectsLogic.run(categoryChoice);
			} else if (categoryChoice == oneProjectLogic.getProject(index).getCategory().getId()
					&& projectChoice == oneProjectLogic.getProject(index).getProjectId()) {
				showFooter();
				addData(oneProjectLogic.getProjectFullInfo(index));
				showData();
				showExit();
				showFooter();
				goToProjectLIst = new InputData(printer, reader)
						.inputData(1);
				if (goToProjectLIst == 0) {
					showFooter();
//					ProjectsLogic projectsLogic = new ProjectsLogic(new ConsolePrinter(),
//							new ConsoleReader(), quotes, categories, projects); 
//					projectsLogic.run(categoryChoice);
				} else {
					showError();
					showFooter();
//					OneProjectLogic oneProjectLogic = new OneProjectLogic(new ConsolePrinter(),
//							new ConsoleReader(), quotes, categories, projects); 
//					oneProjectLogic.run(categoryChoice, projectChoice);
				}
		
			}
		}
		return goToProjectLIst;
	}
}
