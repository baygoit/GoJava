package ua.nenya.main;


import java.util.Arrays;
import java.util.List;

import ua.nenya.pages.CategoriesPage;
import ua.nenya.pages.EnteringPage;
import ua.nenya.project.Category;
import ua.nenya.project.User;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;
import ua.nenya.dao.memory.QuoteDaoMemoryImpl;
import ua.nenya.enums.EnteringPageEnum;

public class Kickstarter {
	
	private List<User> users;
	private List<Category> categories;
	private IO io;
	
	private ListUtilits listUtil = new ListUtilits();
	private EnteringPage enteringPage = new EnteringPage();
	private CategoriesPage categoriesPage = new CategoriesPage();

	public Kickstarter(List<User> users, List<Category> categories, IO io) {
		this.categories = categories;
		this.io = io;
		this.users = users;
	}

	public void run() {
		io.writeln(new QuoteDaoMemoryImpl().getRandomQuote().getName());
		io.writeln("");
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

}
