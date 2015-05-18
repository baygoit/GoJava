package com.go_java4.alex_mirn.input_output.pages;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.Reader;

public class CategoriesPage {
	private Printer printer;
	private Reader reader;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;

	public CategoriesPage(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
		header = "Please enter the number of the category you want to choose"
				+ " or press \"0\" to leave the programm:\n";
		data = "";
		footer = "---------------";
		exit = "Bye";
		error = "";
	}

	public void addQuote(Quote quote) {
		header = quote.toString() + "\n\n" + header;
	}
	
	public void showHeader() {
		printer.println(header);
	}

	public void addData(int index, Category category) {
		data += Integer.toString(index + 1) + ". " + category + "\n";
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

}
