package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.dao.Dao;
import ua.com.gojava4.kickstarter.entities.DataIOTypeStorage;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;
import ua.com.gojava4.kickstarter.view.pages.CategoriesPage;
import ua.com.gojava4.kickstarter.view.pages.Page;

public class Kickstarter {

	DataIOTypeStorage dataIOTypeStorage;

	public Kickstarter(DataIOTypeStorage dataIOTypeStorage) {
		this.dataIOTypeStorage = dataIOTypeStorage;
	}

	public void run() {
		dataIOTypeStorage.getWriter().println("Welcome to Kickstarter developed by Vlad");
		boolean isExit = false;
		while (!isExit) {
			Page currentPage = new CategoriesPage(dataIOTypeStorage);
			currentPage.showPage();
				try {
					currentPage = currentPage.getNextPage();
				}
				catch (ExitProgramException e){
					isExit = true;		
					dataIOTypeStorage.getWriter().print("Bye! Have a nice day!");
				}
		}
	}
}
