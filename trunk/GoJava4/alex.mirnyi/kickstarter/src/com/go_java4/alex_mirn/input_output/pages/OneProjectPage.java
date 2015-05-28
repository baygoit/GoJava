package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.util.Map;

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
import com.go_java4.alex_mirn.input_output.pages.State;

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

	public OneProjectPage(Printer printer, Reader reader, Repository repository) {
		this.printer = printer;
		this.reader = reader;
		this.oneProjectLogic = new OneProjectLogic(repository);
		this.repository = repository;
		header = "You have chosen ";
		data = "";
		footer = "---------------";
		exit = "To go back to the list of projects press \"0\"";
		error = "Invalid input number!!! Try again";
	}
	
	public void run(Map<String, String> map) throws IOException{
		int categoryChoice = Integer.parseInt(map.get("categoryChoice"));
		int projectChoice = Integer.parseInt(map.get("projectChoice"));
		for (int index = 0; index < oneProjectLogic.getSize(); index++) {
			if (categoryChoice == oneProjectLogic.getProject(index).getCategory().getId()
					&& projectChoice == oneProjectLogic.getProject(index).getProjectId()) {
				showFooter();
				addData(oneProjectLogic.getProjectFullInfo(index));
				showData();
				showExit();
				showFooter();
			}
		}
	}

	
	public State makeChoice(Map<String, String> map) throws IOException{
		int goToProjectLIst = new InputData(printer, reader)
		.inputData(oneProjectLogic.getSize());
		if (goToProjectLIst != 0) {
			showError();
			showFooter();
			showData();
			showExit();
			showFooter();
			makeChoice(map);
		} else {
			showFooter(); 
		}
		return State.PROJECTS_PAGE;
	}
	
	public void goBack(Map<String, String> map){}
	
	public void goNext(Map<String, String> map){}
	
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
	
//	public void runOneProject(int categoryChoice, int projectChoice) throws IOException {
//		for (int index = 0; index < oneProjectLogic.getSize(); index++) {
//			if (projectChoice == 0) {
//				showFooter(); 
//				ProjectsPage projectsPage = new ProjectsPage(new ConsolePrinter(),
//						new ConsoleReader(), repository);
//				projectsPage.runProjects(categoryChoice);
//			} else if (categoryChoice == oneProjectLogic.getProject(index).getCategory().getId()
//					&& projectChoice == oneProjectLogic.getProject(index).getProjectId()) {
//				showFooter();
//				addData(oneProjectLogic.getProjectFullInfo(index));
//				showData();
//				showExit();
//				showFooter();
//				int goToProjectLIst = new InputData(printer, reader)
//						.inputData(1);
//				if (goToProjectLIst == 0) {
//					showFooter(); 
//					ProjectsPage projectsPage = new ProjectsPage(new ConsolePrinter(),
//							new ConsoleReader(), repository);
//					projectsPage.runProjects(categoryChoice);
//				} else {
//					showError();
//					showFooter(); 
//					OneProjectPage oneProjectPage = new OneProjectPage(new ConsolePrinter(),
//							new ConsoleReader(), repository);
//					oneProjectPage.runOneProject(categoryChoice, projectChoice);
//				}
//		
//			}
//		}
//	}
}
