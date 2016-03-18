package ua.nenya.main;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ua.nenya.pages.CategoriesPage;
import ua.nenya.pages.EnteringPage;
import ua.nenya.project.Category;
import ua.nenya.project.Quote;
import ua.nenya.project.User;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;
import ua.nenya.dao.QuoteDao;
import ua.nenya.enums.EnteringPageEnum;

public class Kickstarter {
	
	private List<User> users;
	private List<Category> categories;
	private IO io;
	
	private ListUtilits listUtil = new ListUtilits();
	private EnteringPage enteringPage = new EnteringPage();
	private CategoriesPage categoriesPage = new CategoriesPage();
	private QuoteDao quoteInit;

	public Kickstarter(QuoteDao quoteInit, List<User> users, List<Category> categories, IO io) {
		this.quoteInit = quoteInit;
		this.categories = categories;
		this.io = io;
		this.users = users;
	}

	public void run() {
		showQuote();
		int index;
		List<EnteringPageEnum> list = Arrays.asList(EnteringPageEnum.values());
		while ((index = listUtil.choseIndexFromList(list, io)) != 0) {
			EnteringPageEnum item = list.get(index-1);
			io.writeln("You've chosen "+item.getName());
			if (item.equals(EnteringPageEnum.GO_TO_CATEGORIES)) {
				categoriesPage.showAllCategories(categories, io, listUtil);
			} else {
				enteringPage.enter(users, categories, io, listUtil);
			}
		}
	}

	private void showQuote() {
		Quote quote = quoteInit.getRandomQuote(new Random());
		io.writeln(quote.getName());
		io.writeln("");
	}

}
