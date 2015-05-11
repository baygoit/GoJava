package InputOutput.pages;

import Data.Quote;
import Data.Category;
import Data.Project;
import InputOutput.printers.Printer;
import InputOutput.readers.ConsoleReader;
import InputOutput.readers.Reader;

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