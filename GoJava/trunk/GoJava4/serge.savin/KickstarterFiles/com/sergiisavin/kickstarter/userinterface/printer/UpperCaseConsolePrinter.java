package com.sergiisavin.kickstarter.userinterface.printer;


public class UpperCaseConsolePrinter implements Printer {

	@Override
	public void print(String text) {
		System.out.println(text.toUpperCase());
	}

}
