package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;




import java.util.Map;

import com.go_java4.alex_mirn.Repository;
import com.go_java4.alex_mirn.input_output.InputData;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.input_output.pages.AbstractPage;
import com.go_java4.alex_mirn.input_output.pages.IPage;
import com.go_java4.alex_mirn.logic.CategoriesLogic;


public class CategoriesPage implements IPage{
	private Printer printer;
	private Reader reader;
	private CategoriesLogic categoriesLogic;
	private Repository repository;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;
	public IPage previousPage;

	public CategoriesPage(Printer printer, Reader reader, 
			Repository repository) {
		this.printer = printer;
		this.reader = reader;
		this.categoriesLogic = new CategoriesLogic(repository);
		this.repository = repository;
		this.previousPage = null;
		header = "Please enter the number of the category you want to choose"
				+ " or press \"0\" to leave the programm:\n";
		data = "";
		footer = "---------------";
		exit = "Bye";
		error = "Invalid input number!!! Try again";
	}
	
	public void run(Map<String, String> choice) throws IOException{
		if (data == "") {
			addQuote();
			showHeader();
			for (int index = 0; index < categoriesLogic.getSize(); index++) {
				addData(index, categoriesLogic.getIndex(index));
			}
			showData();
			showFooter();
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}
	
	public State makeChoice(Map<String, String> choice) throws IOException{
		int categoryChoice = new InputData(printer, reader).inputData(categoriesLogic.getSize());
		choice.put("categoryChoice", Integer.toString(categoryChoice));
		
		if (categoryChoice == 0) {
			showExit();
			System.exit(0);
			return State.CATEGORIES_PAGE;
		} else {
			return State.PROJECTS_PAGE;
		}
	}

	private void addQuote() {
		header = categoriesLogic.getQuote() + "\n\n" + header;
	}
	
	private void showHeader() {
		printer.println(header);
	}

	private void addData(int index, String category) {
		data += Integer.toString(index + 1) + ". " + category + "\n";
	}

	private void showData() {
		printer.println(data);
	}

	private void showFooter() {
		printer.println(footer);
	}

	private void showExit() {
		printer.println(exit);
	}
	
}
