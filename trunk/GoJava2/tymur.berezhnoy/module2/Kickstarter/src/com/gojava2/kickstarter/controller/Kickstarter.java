package com.gojava2.kickstarter.controller;

import java.util.Random;

import com.gojava2.kickstarter.model.CategoryStorage;
import com.gojava2.kickstarter.model.CategoryStorageInFile;
import com.gojava2.kickstarter.model.ProjectStorage;
import com.gojava2.kickstarter.model.ProjectStorageInFile;
import com.gojava2.kickstarter.model.QuoteStorage;
import com.gojava2.kickstarter.model.QuoteStorageInFile;
import com.gojava2.kickstarter.view.ConsoleInput;
import com.gojava2.kickstarter.view.ConsoleView;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = new QuoteStorageInFile(new Random(), "Data/Quotes.json");
		CategoryStorage categoryStorage = new CategoryStorageInFile("Data/Categories.json");
		ProjectStorage projectStorage = new ProjectStorageInFile("Data/Projects.json");
		
		KickstarterController app = new KickstarterController(quoteStorage, categoryStorage,
																projectStorage, new ConsoleView(),
																new ConsoleInput());
		app.run();
	}
}