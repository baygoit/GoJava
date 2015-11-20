package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.fileStorage.QuoteFileStorage;
import ua.com.goit.gojava7.kickstarter.memoryStorages.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.memoryStorages.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

// OLEG do we need so many comments here?
// OLEG to big main method - think how to split it
public class KickstarterRunner {

	public static void main(String[] args) throws IOException {

		ConsoleReader consoleReader = new ConsoleReader();
		ConsolePrinter consolePrinter = new ConsolePrinter();

		if (args.length != 0) {
			QuoteStorage quoteStorage = initQuotes();
			CategoryStorage categoryStorage = initCategiries();
			initProjects(categoryStorage);

			KickstarterFromMemory kickstarterFromMemory = new KickstarterFromMemory(consoleReader, consolePrinter, quoteStorage, categoryStorage);
			kickstarterFromMemory.start();
			kickstarterFromMemory.stop();
		}
		else {
			QuoteFileStorage quotefileStorage = new QuoteFileStorage();
			
			KickstarterFromFiles kickstarterFromFiles = new KickstarterFromFiles(consoleReader, consolePrinter, quotefileStorage);
			kickstarterFromFiles.start();
			kickstarterFromFiles.stop();
		}
	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage(new Random());
		quoteStorage
				.addQuote(
						new Quote(
								"Your work is going to fill a large part of your life,"
										+ " and the only way to be truly satisfied is to do what"
										+ " you believe is great work. And the only way to do"
										+ " great work is to love what you do. If you haven't"
										+ " found it yet, keep looking. Don't settle. As with"
										+ " all matters of the heart, you'll know when you" + " find it.",
								"Steve Jobs."));
		quoteStorage.addQuote(new Quote("Innovation distinguishes between a leader and a follower.", "Steve Jobs."));
		return quoteStorage;
	}

	private static CategoryStorage initCategiries() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.setCategory("Movie");
		categoryStorage.setCategory("Art");
		categoryStorage.setCategory("Food");

		return categoryStorage;
	}

	private static void initProjects(CategoryStorage categoryStorage) {
		Project boondockSaints = new Project("THE BOONDOCK SAINTS",
				"The Boondock Saints is a 1999 American crime film written and directed by Troy Duffy", 1000000, 180);
		boondockSaints.setProjectDescription(
				"The MacManus brothers are living a quiet life in Ireland with their father, but when they learn that their beloved priest has been killed by mob forces, they go back to Boston to bring justice to those responsible and avenge the priest. ");
		boondockSaints.setQuestionsAndAnswer("Is it my question?", "No! this is my answer!");
		boondockSaints.setVideoUrl("http://youtube.com");
		categoryStorage.getCategory(1).addProject(boondockSaints);
	}
}
