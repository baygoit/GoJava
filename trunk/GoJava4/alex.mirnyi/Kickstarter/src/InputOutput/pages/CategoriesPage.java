package InputOutput.pages;

import Data.Quote;
import Data.Category;
import InputOutput.pages.CategoriesPage;
import InputOutput.printers.Printer;
import InputOutput.readers.ConsoleReader;
import InputOutput.readers.Reader;

public class CategoriesPage {
	private Printer printer;
	private Reader reader;
	private String header;
	private String data;
	private String footer;
	private String exit;

	
	public CategoriesPage(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
		header = "Please enter the number of the category you want to choose" +
		        " or press \"0\" to leave the programm:\n";
		data = "";
		footer = "---------------";
		exit = "Bye";
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
