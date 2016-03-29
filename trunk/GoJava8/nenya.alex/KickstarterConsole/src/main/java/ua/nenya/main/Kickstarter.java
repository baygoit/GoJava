package ua.nenya.main;

import java.util.Random;

import ua.nenya.pages.CategoryPage;
import ua.nenya.project.Quote;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class Kickstarter {

	private IO io;
	private ListUtilits listUtil = new ListUtilits();
	private CategoryPage categoriesPage = new CategoryPage();
	private DaoInitilizer initilizer;

	public Kickstarter(DaoInitilizer initilizer, IO io) {
		this.initilizer = initilizer;
		this.io = io;
	}

	public void run() {
		showQuote();
		categoriesPage.showAllCategories(initilizer, io, listUtil);
	}

	private void showQuote() {
		Quote quote = initilizer.getQuoteDao().getRandomQuote(new Random());
		io.writeln(quote.getName());
		io.writeln("");
	}

}
