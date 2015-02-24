package com.gojava2.kickstarter.controller;

import com.gojava2.kickstarter.model.CategoryStorageInVM;
import com.gojava2.kickstarter.model.ProjectStorageInVM;
import com.gojava2.kickstarter.model.QuoteStorageInVM;
import com.gojava2.kickstarter.view.ConsoleView;


public class Kickstarter {

	public static void main(String[] args) {
		KickstarterController engine = new KickstarterController(new QuoteStorageInVM(), new CategoryStorageInVM(),
																new ProjectStorageInVM(), new ConsoleView());
		engine.run();
	}
}