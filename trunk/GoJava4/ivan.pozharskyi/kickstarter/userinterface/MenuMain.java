package com.ivanpozharskyi.kickstarter.userinterface;

import com.ivanpozharskyi.kickstarter.datastorage.CategoryStorage;
import com.ivanpozharskyi.kickstarter.datastorage.QuotesStorage;
import com.ivanpozharskyi.kickstarter.engine.Printer;

public class MenuMain implements Menu{
	private QuotesStorage quotes;
	private CategoryStorage categogorys;
	private Printer printer;
	@Override
	public void show() {
		System.out.println("================================");
		System.out.println(" " + quotes.getRandomQuote());
		System.out.println("================================\n");
		System.out.println(" " + categogorys.getAllCategorys());
		System.out.println("Choose category: ");
	}
	@Override
	public void setChoise(Object choise) {	
		
	}

}
