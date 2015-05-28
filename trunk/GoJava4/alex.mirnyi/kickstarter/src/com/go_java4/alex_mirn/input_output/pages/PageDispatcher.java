package com.go_java4.alex_mirn.input_output.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.go_java4.alex_mirn.Repository;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.Reader;
//import com.go_java4.alex_mirn.input_output.pages.State;

public class PageDispatcher {
	State state = State.CATEGORIES_PAGE;
	private Printer printer;
	private Reader reader;
	private Repository repository;
	private IPage ipage;
	private static Map<String, String> choice = new HashMap<String, String>();
	
	public PageDispatcher(Printer printer, Reader reader, Repository repository) {
		this.printer = printer;
		this.reader = reader;
		this.repository = repository;
		this.ipage = new CategoriesPage(printer, reader, repository);
	}


	public void run() throws IOException {
		while (true) {
			switch (state) {
		        case CATEGORIES_PAGE:
		        	ipage = new CategoriesPage(printer, reader, repository);
		        	ipage.run(choice);
		        	state = ipage.makeChoice(choice);
		        	if (state == State.CATEGORIES_PAGE) {
		        		ipage.goBack(choice);
		        	}
		        break;
		        case PROJECTS_PAGE:
		        	ipage = new ProjectsPage(printer, reader, repository);
		        	ipage.run(choice);
		        	state = ipage.makeChoice(choice);
		        break;
		        case ONE_PROJECT_PAGE:
		        	ipage = new OneProjectPage(printer, reader, repository);
		        	ipage.run(choice);
		        	state = ipage.makeChoice(choice);
		        break;
			}
		}
	}
	

}
