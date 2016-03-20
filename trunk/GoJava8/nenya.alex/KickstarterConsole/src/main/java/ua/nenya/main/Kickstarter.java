package ua.nenya.main;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ua.nenya.pages.CategoriesPage;
import ua.nenya.pages.EnteringPage;
import ua.nenya.project.Quote;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;
import ua.nenya.enums.EnteringPageEnum;

public class Kickstarter {
	
	private IO io;
	
	private ListUtilits listUtil = new ListUtilits();
	private EnteringPage enteringPage = new EnteringPage();
	private CategoriesPage categoriesPage = new CategoriesPage();
	private KickstarterInitilizer initilizer;

	public Kickstarter(KickstarterInitilizer initilizer, IO io) {
		this.initilizer = initilizer;
		this.io = io;
	}

	public void run() {
		showQuote();
		int index;
		List<EnteringPageEnum> list = Arrays.asList(EnteringPageEnum.values());
		while ((index = listUtil.choseIndexFromList(list, io)) != 0) {
			EnteringPageEnum item = list.get(index-1);
			io.writeln("You've chosen "+item.getName());
			if (item.equals(EnteringPageEnum.GO_TO_CATEGORIES)) {
				categoriesPage.showAllCategories(initilizer, io, listUtil);
			} else {
				enteringPage.enter(initilizer, io, listUtil);
			}
		}
	}

	private void showQuote() {
		Quote quote = initilizer.getQuoteDao().getRandomQuote(new Random());
		io.writeln(quote.getName());
		io.writeln("");
	}

}
