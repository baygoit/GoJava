package com.sergiisavin.kickstarter.UserInterface;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sergiisavin.kickstarter.Kickstarter;
import com.sergiisavin.kickstarter.category.container.Categories;
import com.sergiisavin.kickstarter.category.container.memory.CategoriesContainer;
import com.sergiisavin.kickstarter.quote.container.Quotes;
import com.sergiisavin.kickstarter.quote.container.memory.QuotesContainer;
import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.pages.PageType;
import com.sergiisavin.kickstarter.userinterface.printer.ConsolePrinter;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;

public class PageDispatcherTest {

	@Test
	public void test() {
		Printer printer = new ConsolePrinter();
		PageDispatcher pageDispatcher = new PageDispatcher();
		pageDispatcher.injectPrinter(printer);
		Kickstarter kickstarter = new Kickstarter();
		Quotes quotes = new QuotesContainer("Easy come - easy go", "An apple a day keeps doctors away", "A good speach"
				+ " must be as girls skirt: short enaugh to be interesting and long enaugh to cover the subject");
		kickstarter.setQuotes(quotes);
		Categories categories = new CategoriesContainer("Toys", "Software", "Gadgets");
		kickstarter.setCategories(categories);
		pageDispatcher.setKickstarter(kickstarter);
		pageDispatcher.requestPage(PageType.MAIN_MENU_PAGE, null);
	}

}
