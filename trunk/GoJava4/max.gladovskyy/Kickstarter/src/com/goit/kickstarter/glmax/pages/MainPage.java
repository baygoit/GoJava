package com.goit.kickstarter.glmax.pages;

import com.goit.kickstarter.glmax.enteties.Entetie;

public class MainPage extends Page {
	
	public MainPage(Entetie entetie) {
		super(entetie);
	}

	@Override
	protected void prepareFormatedPage() {
		formatedPage.add("Welcome to KickStarter");
		formatedPage.add("We can make a kick for you start :)");
		formatedPage.add("");
		formatedPage.add(this.entetie.getName());
		formatedPage.add("");
		formatedPage.add("Plese choose category from list below:");
		fillMenu();
		formatedPage.add("");
		formatedPage.add("0) Quit.");
	}
	
}
