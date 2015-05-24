package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.view.Printer;


public class ErrorPage implements Page {
	
	private PageId id;
	private Printer printer;
	

	public ErrorPage(Printer printer) {
		this.printer = printer;  
		id = PageId.ERROR;
	}

	@Override
	public void showPage() {
		printer.println("Invalid input");
	}

	@Override
	public PageId getPageId() {
		return id;
	}

}
