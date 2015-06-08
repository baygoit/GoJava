package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;
import ua.com.gojava4.kickstarter.view.pages.CategoriesPage;
import ua.com.gojava4.kickstarter.view.pages.Page;

public class Kickstarter {

	Reader reader;
	Writer writer;
	Dao genericDao;

	public Kickstarter(Reader reader, Writer writer, Dao genericDao) {
		this.reader = reader;
		this.writer = writer;
		this.genericDao = genericDao;
	}

	public void run() {
		writer.println("Welcome to Kickstarter developed by Vlad");
		boolean isExit = false;
		while (!isExit) {
			Page currentPage = new CategoriesPage(reader, writer, genericDao);
			currentPage.showPage();
				try {
					currentPage = currentPage.getNextPage();
				}
				catch (ExitProgramException e){
					isExit = true;		
					writer.print("Bye! Have a nice day!");
				}
		}
	}
}
