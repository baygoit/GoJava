package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.pages.CategoriesPage;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;

import static org.mockito.Mockito.*;

public class CategoriesPageTest {

	@Test
	public void test() {
		Kickstarter kickstarterMock = mock(Kickstarter.class);
		when(kickstarterMock.getCategories()).thenReturn(new String[] {"Toys", "Gadgets"});
		
		PageDispatcher dispatcherMock = mock(PageDispatcher.class);
		
		Printer printer = new UpperCaseConsolePrinter();
		
		CategoriesPage page = new CategoriesPage(printer);
		
		page.injectKickcstarter(kickstarterMock);
		page.injectPageDispatcher(dispatcherMock);
		
		page.constructPage();
		page.show();
	}

}
