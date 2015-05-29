package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sergiisavin.kickstarter.userinterface.printer.ConsolePrinter;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;

public class ConsolePrinterTest {

	@Test
	public void test() {
		Printer printer = new ConsolePrinter();
		String testString = "Hello";
		printer.print(testString);
	}

}
