package com.sergiisavin.kickstarter.UserInterface;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.pages.Page;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;

public class PageTest {


	@Test
	public void test() {
		Printer printer = new UpperCaseConsolePrinter();
		PageDispatcher dispatcher = new PageDispatcher();
		Page page = new Page(printer);
		page.injectPageDispatcher(dispatcher);
		page.constructPage();
		page.show();
	}

}
