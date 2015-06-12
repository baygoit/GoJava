package com.ivanpozharskyi.kickstarter.userinterface;

import java.sql.SQLException;
import java.util.Set;

import com.ivanpozharskyi.kickstarter.engine.Printer;
import com.ivanpozharskyi.kickstarter.entity.Categories;
import com.ivanpozharskyi.kickstarter.entity.Category;
import com.ivanpozharskyi.kickstarter.entity.CategoriesImpl;
import com.ivanpozharskyi.kickstarter.entity.Quotes;
import com.ivanpozharskyi.kickstarter.entity.QuotesImpl;

public class MenuMain implements Menu {
	private Quotes quotes;
	private Set<Category> categories;
	private Printer printer;

	public MenuMain(Set<Category> categories,Quotes quotes,Printer printer) {
		this.categories = categories;
		this.quotes = quotes;
		this.printer = printer;

	}

	@Override
	public void show() throws SQLException {
		printer.println("================================");
		printer.println(" " + quotes.getRandom());
		printer.println("================================\n");
	
		for(Category category: categories ){
			printer.println(category.toString() + "\n");
		}
		
		printer.println("Choose category: ");

	}

	@Override
	public void setChoise(Object choise) {

	}

}
