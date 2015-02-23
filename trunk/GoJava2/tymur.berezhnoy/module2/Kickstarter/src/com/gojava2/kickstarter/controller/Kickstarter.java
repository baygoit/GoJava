package com.gojava2.kickstarter.controller;

import com.gojava2.kickstarter.model.CategoryStorage;
import com.gojava2.kickstarter.model.ProjectStorage;
import com.gojava2.kickstarter.model.QuoteStorage;
import com.gojava2.kickstarter.view.ConsoleView;


public class Kickstarter {

	public static void main(String[] args) {
		KickstarterController engine = new KickstarterController(new QuoteStorage(), new CategoryStorage(),
																new ProjectStorage(), new ConsoleView());
		engine.run();
	}
}