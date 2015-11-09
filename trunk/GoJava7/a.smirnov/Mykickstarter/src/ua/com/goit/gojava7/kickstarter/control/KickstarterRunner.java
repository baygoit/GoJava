package ua.com.goit.gojava7.kickstarter.control;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectsStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuotesStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterRunner {

	public static void main(String[] args) {
		
		QuotesStorage quotesStorage = initQuotes();
		CategoriesStorage categoriesStorage = initCategories();
		ProjectsStorage projectsStorage = initProjects(categoriesStorage);
		ConsoleScanner consoleScanner = new ConsoleScanner();
		ConsolePrinter consolePrinter = new ConsolePrinter();

		Kickstarter kickstarter = new Kickstarter(consoleScanner, consolePrinter, 
				categoriesStorage, quotesStorage, projectsStorage);

		consolePrinter.print(quotesStorage.getRandomQuote());
		kickstarter.start();
		kickstarter.shutdown();
	}

	public static QuotesStorage initQuotes() {
		QuotesStorage quotesStorage = new QuotesStorage();
		Quote quote1 = new Quote();
		quote1.setQuoteText(
				"Every truth passes through three stages before " + "it is recognized. In the first, it is ridiculed. "
						+ "In the second, it is opposed. In the third, " + "it is regarded as self evident.");
		quote1.setAuthor("Arthur Schopenhauer");

		Quote quote2 = new Quote();
		quote2.setQuoteText("Liberty will not descend to a people, a people must "
				+ "raise themselves to liberty; it is a blessing that must " + "be earned before it can be enjoyed.");
		quote2.setAuthor("B. Franklin");

		Quote quote3 = new Quote();
		quote3.setQuoteText("Government's first duty is to protect the people, not " + "run their lives.");
		quote3.setAuthor("Ronald Reagan");

		Quote quote4 = new Quote();
		quote4.setQuoteText("The most terrifying words in the English language are: "
				+ "I'm from the government and I'm here to help.");
		quote4.setAuthor("Ronald Reagan");

		quotesStorage.add(quote1);
		quotesStorage.add(quote2);
		quotesStorage.add(quote3);
		quotesStorage.add(quote4);

		return quotesStorage;
	}

	public static CategoriesStorage initCategories() {
		CategoriesStorage categoriesStorage = new CategoriesStorage();
		Category category1 = new Category("Arts");
		Category category2 = new Category("Movie");
		Category category3 = new Category("Sports");
		Category category4 = new Category("Culture");
		Category category5 = new Category("Food");

		categoriesStorage.add(category1);
		categoriesStorage.add(category2);
		categoriesStorage.add(category3);
		categoriesStorage.add(category4);
		categoriesStorage.add(category5);

		return categoriesStorage;
	}
	
	public static ProjectsStorage initProjects(CategoriesStorage categoriesStorage) {
		ProjectsStorage projectsStorage = new ProjectsStorage();
		
		Project project1 = new Project("Broadway Arts Lab Company presents Elf JR: The Musical", 
				"A nonprofit arts education program for young people to explore their unique and "
				+ "individual talents through Musical Theatre.", 30_000, 7, 12, 2015);
		project1.addCategoryToProject(categoriesStorage.getListOfSource().get(0));
		project1.addFullDescription("In 2012 the BROADWAY ARTS LAB COMPANY (BALC) opened its doors to "
				+ "young artists providing a safe environment to explore their unique and individual "
				+ "talents through the medium of live theatre, specifically acting, singing, dancing "
				+ "and music.");
		project1.addLinkOnVideo("https://d2pq0u4uni88oo.cloudfront.net/projects/2113569/video-592557-h264_high.mp4");
		project1.addQuestion("I like description of your project. Can you provide more pics?");
		project1.addAnswer("Yes, We are going to add pics ASAP");

		Project project2 = new Project("Bassel's Street Food", 
				"Super amazing street food from quality ingredients.", 45_000, 15, 12, 2015);
		project2.addCategoryToProject(categoriesStorage.getListOfSource().get(2));
		project2.addFullDescription("Clear Food is the authoritative online food guide for consumers. "
				+ "We are evaluating food at the molecular level to surface insights about our food that "
				+ "go far beyond the label. We can discover hidden additives, trace allergens, and unintended "
				+ "ingredients. Is your veggie burger really meat-free? Are your kids’ chicken nuggets 100% "
				+ "chicken like the label says? Is there wheat in your gluten-free pizza crust? Our "
				+ "advanced genomic analysis uncovers it all.");
		project2.addLinkOnVideo("https://d2pq0u4uni88oo.cloudfront.net/projects/2137323/video-604147-h264_high.mp4");
		project2.addQuestion("I like description of your project. Can you provide more pics?");
		project2.addAnswer("Yes, We are going to add pics ASAP");
	
		Project project3 = new Project("First Ever Soft Shell Football Helmet", 
				"Designed by former NFL players, Rocksolid brings to you the RS1, "
				+ "the world's first soft shell helmet created specifically for football", 120_000, 11, 12, 2015);
		project3.addCategoryToProject(categoriesStorage.getListOfSource().get(2));
		project3.addFullDescription("As former NFL players, we are committed to adding protection to football and"
				+ " making it more enjoyable for everyone. There's a major void in player safety in non-contact play, "
				+ "such as flag football, 7v7, padless play, and off-season practice. Did you know that 80% of practice "
				+ "time is without traditional football pads, and that most injuries actually occur in the off-season?");
		project3.addLinkOnVideo("https://d2pq0u4uni88oo.cloudfront.net/projects/2015663/video-594783-h264_high.mp4");
		project3.addQuestion("Amazing project. Can you provide email to me, I will send you my idea for improving?");
		project3.addAnswer("Hello, here you are: bigboss@gmail.com");
		projectsStorage.add(project1);
		projectsStorage.add(project2);
		projectsStorage.add(project3);
		
		return projectsStorage;
	}

}
