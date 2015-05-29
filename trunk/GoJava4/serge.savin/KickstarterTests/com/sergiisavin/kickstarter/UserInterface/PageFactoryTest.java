package com.sergiisavin.kickstarter.UserInterface;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sergiisavin.kickstarter.userinterface.pagefactory.PageFactory;
import com.sergiisavin.kickstarter.userinterface.pages.Page;
import com.sergiisavin.kickstarter.userinterface.pages.PageType;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;

public class PageFactoryTest {

	@Test
	public void testCreatePageFactory() {
		PageFactory factory = new PageFactory(new UpperCaseConsolePrinter());
		Page page = factory.createPage(PageType.CATEGORIES_PAGE);
	}

}
