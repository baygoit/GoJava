package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import com.go_java4.alex_mirn.logic.CategoriesLogic;
import com.go_java4.alex_mirn.logic.OneProjectLogic;
import com.go_java4.alex_mirn.logic.ProjectsLogic;
import com.go_java4.alex_mirn.input_output.pages.State;

public class ProjectsPage implements IPage{
	private static List<Integer> inputCheck = new ArrayList<Integer>();
	private Printer printer;
	private Reader reader;
	private ProjectsLogic projectsLogic;
	private Repository repository;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;

	public ProjectsPage(Printer printer, Reader reader, Repository repository) {
		this.printer = printer;
		this.reader = reader;
		this.projectsLogic = new ProjectsLogic(repository);
		this.repository = repository;
		header = "Please enter a number of project for more information"
				+ " or press \"0\" to see project menu:\n\n"
				+ "You have chosen category ";
		data = "";
		footer = "---------------";
		exit = "";
		error = "Invalid input number!!! Try again";
	}
	
	public void run(Map<String, String> map){
		int categoryChoice = Integer.parseInt(map.get("categoryChoice"));
		addHeader(projectsLogic.getCategory(categoryChoice - 1));
		showHeader();
		for (int index = 0; index < projectsLogic.getSize(); index++) {
				if (categoryChoice == projectsLogic.getProject(index).getCategory()
						.getId()) {
				inputCheck.add(index + 1);
				addData(projectsLogic.getProject(index));
			}
		}
		showData();
		showFooter();
	}
	
	public State makeChoice(Map<String, String> map) throws IOException{
		int projectChoice = new InputData(printer, reader).inputData(projectsLogic
				.getSize());
		map.put("projectChoice", Integer.toString(projectChoice));
		if (projectChoice == 0) {
			showFooter(); 
			return State.CATEGORIES_PAGE;
		} else if (inputCheck.contains(projectChoice)) { 
			return State.ONE_PROJECT_PAGE;
		} else {
			showError();
			showFooter();
			showHeader();
			showData();
			return makeChoice(map);
		}
	}
	
	public void goBack(Map<String, String> map){}
	
	public void goNext(Map<String, String> map){}
	
	public void showHeader() {
		printer.println(header);
	}

	public void addHeader(Category category) {
		header += category.toString() + "\n";
	}

	public void addData(Project project) {
		data += project.toString() + "\n";
	}
	
	
	public void showData() {
		printer.println(data);
	}

	public void showFooter() {
		printer.println(footer);
	}

	public void showError() {
		printer.println(error);
	}

	
//	public void runProjects(int categoryChoice) throws IOException {
//		addHeader(projectsLogic.getCategory(categoryChoice - 1));
//		showHeader();
//		List<Integer> inputCheck = new ArrayList<Integer>();
//		for (int index = 0; index < projectsLogic.getSize(); index++) {
//				if (categoryChoice == projectsLogic.getProject(index).getCategory()
//						.getId()) {
//				inputCheck.add(index + 1);
//				addData(projectsLogic.getProject(index));
//			}
//		}
//		showData();
//		showFooter();
//		int projectChoice = new InputData(printer, reader).inputData(projectsLogic
//				.getSize());
//		if (projectChoice == 0) {
//			showFooter(); 
//			CategoriesPage categoriesPage = new CategoriesPage(new ConsolePrinter(),
//				new ConsoleReader(), repository); 
//			categoriesPage.runCategories();
//		} else if (inputCheck.contains(projectChoice)) { 
//			OneProjectPage oneProjectPage = new OneProjectPage(new ConsolePrinter(),
//					new ConsoleReader(), repository);
//			oneProjectPage.runOneProject(categoryChoice, projectChoice);
//		} else {
//			showError();
//			showFooter(); 
//			ProjectsPage projectsPage = new ProjectsPage(new ConsolePrinter(),
//					new ConsoleReader(), repository);
//			projectsPage.runProjects(categoryChoice);
//		}
//	}
}

