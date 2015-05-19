package com.go_java4.alex_mirn.input_output.pages;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.input_output.pages.CategoriesPage;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;

public class ProjectsPage {
	private Printer printer;
	private Reader reader;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;

	public ProjectsPage(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
		header = "Please enter a number of project for more information"
				+ " or press \"0\" to see project menu:\n\n"
				+ "You have chosen category ";
		data = "";
		footer = "---------------";
		exit = "";
		error = "Invalid input number!!! Try again";
	}

	public void showHeader() {
		printer.println(header);
	}

	public void addHeader(Category category) {
		header += category + "\n";
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

}