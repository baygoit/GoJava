package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sergiisavin.kickstarter.userinterface.pages.MainMenuPage;
import com.sergiisavin.kickstarter.userinterface.pages.WelcomeUserPage;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;

import static org.mockito.Mockito.*;
public class WelcomeUserPageTest {

	@Test
	public void test() {
		Kickstarter kickstarterMock = mock(Kickstarter.class);
		when(kickstarterMock.getRandomQuote()).thenReturn("Quote of the day!");
		//PageDispatcher dispatcherMock = mock(PageDispatcher.class);
		Printer printer = new UpperCaseConsolePrinter();
		WelcomeUserPage page = new WelcomeUserPage(printer);
		assertNotNull(page);
		page.injectKickcstarter(kickstarterMock);
		//page.injectPageDispatcher(dispatcherMock);
		
		page.constructPage();
		//page.show();
	}

}
