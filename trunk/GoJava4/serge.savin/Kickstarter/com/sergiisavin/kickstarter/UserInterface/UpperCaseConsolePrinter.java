package com.sergiisavin.kickstarter.UserInterface;

public class UpperCaseConsolePrinter implements Printer {

	@Override
	public void print(String text) {
		System.out.println(text.toUpperCase());
	}

}
