package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterFlow {
	public static void main(String[] args) {
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleReader consoleReader = new ConsoleReader();
		QuoteStorage quoteStorage = initQuoteStorage();
		CategoryStorage categoryStorage = initCategoryStorage();
		
		Kickstarter kickstarter = new Kickstarter(consoleReader, consolePrinter, 
				quoteStorage, categoryStorage);
								
		kickstarter.startKickstarter();
	}

	private static QuoteStorage initQuoteStorage() {
		QuoteStorage quoteStorage = new QuoteStorage(new Random());
		quoteStorage.add(new Quote(
				"No truly great person ever thought themselves so.", "William Hazlitt"));
		quoteStorage.add(new Quote(
				"I always look forward to working with Goldie "
				+ "because she's a great person to work with.", "Kurt Russell"));
		return quoteStorage;	
	}
	
	private static CategoryStorage initCategoryStorage() {
		CategoryStorage categoryStorage = new CategoryStorage();
		
		Category category1 = new Category("Art");
		
		Project projectInArt1 = new Project("Art1", "ArtSummary1", 35000L);
		projectInArt1.setInfo("ArtInfo1");
		projectInArt1.setHistory("ArtHistory1");
		projectInArt1.setPledged(23400L);
		projectInArt1.setVideo("ArtVideo1");
		projectInArt1.setQuestionsAndAnswers("ArtFaq1");
		
		Project projectInArt2 = new Project("Art2", "ArtSummury2", 75000L);
		
		category1.getProjects().add(projectInArt1);
		category1.getProjects().add(projectInArt2);
		
		categoryStorage.addCategory(category1);

		Category category2 = new Category("Comics");
		
		Project projectInComics1 = new Project("Comics1", "ComicsSummary1", 12000L);
		Project projectInComics2 = new Project("Comics2", "ComicsSummary2", 12000L);
		
		category2.getProjects().add(projectInComics1);
		category2.getProjects().add(projectInComics2);
		
		categoryStorage.addCategory(category2);
		
		categoryStorage.addCategory(new Category("Crafts"));
		categoryStorage.addCategory(new Category("Dance"));
		categoryStorage.addCategory(new Category("Design"));
		
		return categoryStorage;
	}
}
