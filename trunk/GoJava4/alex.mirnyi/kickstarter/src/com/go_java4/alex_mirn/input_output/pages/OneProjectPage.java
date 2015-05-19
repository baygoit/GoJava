package com.go_java4.alex_mirn.input_output.pages;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.input_output.pages.CategoriesPage;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;

public class OneProjectPage {
	private Printer printer;
	private Reader reader;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;

	public OneProjectPage(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
		header = "You have chosen ";
		data = "";
		footer = "---------------";
		exit = "To go back to the list of projects press \"0\"";
		error = "You entered wrong number!!!!!!";
	}

	public void showHeader() {
		printer.println(header);
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

}