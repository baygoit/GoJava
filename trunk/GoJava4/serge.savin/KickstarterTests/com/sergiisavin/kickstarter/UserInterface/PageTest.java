package com.sergiisavin.kickstarter.UserInterface;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

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
