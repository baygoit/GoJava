package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.view.pages.CategoriesPage;
import ua.com.gojava4.kickstarter.view.pages.Page;

public class Kickstarter {

	private DataIOTypeStorage dataIOTypeStorage;

	public Kickstarter(DataIOTypeStorage dataIOTypeStorage) {
		this.dataIOTypeStorage = dataIOTypeStorage;
	}

	public void run() {
		dataIOTypeStorage.getWriter().println("Welcome to Kickstarter developed by Vlad");
		Page currentPage = new CategoriesPage(dataIOTypeStorage);
		boolean isExit = false;
		
		while (!isExit) {
			currentPage.showPage();
			currentPage = currentPage.getNextPage();
//			isExit = true;
//			dataIOTypeStorage.getWriter().print("Bye! Have a nice day!");
		}
	}
}
