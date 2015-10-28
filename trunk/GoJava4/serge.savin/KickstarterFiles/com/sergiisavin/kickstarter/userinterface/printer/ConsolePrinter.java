package com.sergiisavin.kickstarter.userinterface.printer;


public class ConsolePrinter implements Printer {

	@Override
	public void print(String text) {
		System.out.println("****** printing with ConsolePrinter ******");
		System.out.println(text);
	}

}
