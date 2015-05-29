package com.sergiisavin.kickstarter.UserInterface;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sergiisavin.kickstarter.Kickstarter;
import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.pages.PageType;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;

public class PrinterTest {

	@Test
	public void test() {
		Printer printer = new UpperCaseConsolePrinter();
		PageDispatcher dispatcher = new PageDispatcher();
		dispatcher.injectPrinter(printer);
		Kickstarter kickstarter = new Kickstarter();
		dispatcher.setKickstarter(kickstarter);
		dispatcher.requestPage(PageType.MAIN_MENU_PAGE, null);
	}

}
