package com.ivanpozharskyi.kickstarter.userinterface;

import java.util.Set;

import com.ivanpozharskyi.kickstarter.datastorage.Category;
import com.ivanpozharskyi.kickstarter.datastorage.CategoryStorage;
import com.ivanpozharskyi.kickstarter.datastorage.QuotesStorage;
import com.ivanpozharskyi.kickstarter.engine.Printer;

public class MenuMain implements Menu {
	private QuotesStorage quotes;
	private CategoryStorage categorys;
	private Printer printer;

	public MenuMain(CategoryStorage categorys,QuotesStorage quotesStorage,Printer printer) {
		this.categorys = categorys;
		this.quotes = quotesStorage;
		this.printer = printer;

	}

	@Override
	public void show() {
		printer.println("================================");
		printer.println(" " + quotes.getRandomQuote());
		printer.println("================================\n");
		
//		<Category>Set category = categorys.getAllCategorys();
//		for (int i = 0; i < categorys.getSize(); i++) {
//			printer.println(" " + category[i]);
//
//		}
		printer.println(categorys.toString());
		printer.println("Choose category: ");

	}

	@Override
	public void setChoise(Object choise) {

	}

}
