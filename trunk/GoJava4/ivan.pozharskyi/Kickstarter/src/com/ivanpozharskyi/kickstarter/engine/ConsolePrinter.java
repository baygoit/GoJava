package com.ivanpozharskyi.kickstarter.engine;

public class ConsolePrinter implements Printer {

	@Override
	public void println(String string) {

		System.out.println(string);
	}

}
