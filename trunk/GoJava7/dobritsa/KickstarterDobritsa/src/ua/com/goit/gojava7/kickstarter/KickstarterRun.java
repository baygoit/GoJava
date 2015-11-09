package ua.com.goit.gojava7.kickstarter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterRun {
	public static void main(String[] args) {
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleInspector consoleInspector = new ConsoleInspector();

		QuoteStorage quoteStorage = initQuotes();
		CategoryStorage categoryStorage = initCategories();

		Kick kickstarter = new Kick(consolePrinter, consoleInspector, quoteStorage, categoryStorage);
		kickstarter.run();
		kickstarter.shutdown();
	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage.
				add(new Quote("I work to stay alive.", "Bette Davis"));
		quoteStorage.
				add(new Quote("There is only one boss. The customer. And he can fire everybody"
						+ "\n     in the company from the chairman on down, simply by "
						+ "\n     spending his money somewhere else.", "Sam Walton"));
		quoteStorage.
				add(new Quote("Ideas pull the trigger, but instinct loads the gun. ", "Don Marquis"));
		quoteStorage.
				add(new Quote("There are no secrets to success. It is the result of preparation, "
						+ "\n     hard work, and learning from failure. ", "Colin Powell"));
		quoteStorage.
				add(new Quote("Happiness does not come from doing easy work but from the "
						+ "\n     afterglow of satisfaction that comes after the achievement "
						+ "\n     of a difficult task that demanded our best. ", "Theodore Isaac Rubin"));		
		return quoteStorage;
	}

	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.add(new Category("Music"));
		categoryStorage.add(new Category("Dances"));
		categoryStorage.add(new Category("Food"));
		return categoryStorage;
	}



	private static ProjectStorage initMusicStorage() {
		ProjectStorage projectStorage = new ProjectStorage();
		projectStorage.add(new Project(
				"'Critical Mass': New solo music from Jerry Chamberlain!", 
				"You can help Jerry Chamberlain (Daniel Amos, Swirling Eddies, "
				+ "\n     Boy-O-Boy, Pamelita & Parker) record his first solo album! ", 
				20000, 3903, 23, 
				"Forty years ago in 1975, Jerry Chamberlain walked into a "
				+ "\n     professional recording studio for the first time to lay down "
				+ "\n     his initial recorded work as a founding member with Daniel "
				+ "\n     Amos (DA). Since that time, he has played guitar and sung on "
				+ "\n     many artists’ projects, some of those his own (Boy-O-Boy, "
				+ "\n     The Balls Of France), and lent musical support for many "
				+ "\n     recordings. Besides Daniel Amos, Chamberlain has been a "
				+ "\n     long-time member of Swirling Eddies (under the pseudonym of "
				+ "\n     “Spot”). His own songs have surfaced here and there (“Man In "
				+ "\n     The Moon”, “Little Crosses”, etc.), but he has never recorded "
				+ "\n     a solo album. Until now. Announcing the eclectic rock debut "
				+ "\n     from lead guitarist-singer/songwriter/producer, Jerry "
				+ "\n     Chamberlain. We have reached Critical Mass.", 
				"https://d2pq0u4uni88oo.cloudfront.net/projects/2150887/video-600235-h264_high.mp4", 
				"No questions at the moment"));
		projectStorage.add(new Project("Name12", "Description12", 12000, 1200, 12, "history12", "link12", "questions12"));		
		projectStorage.add(new Project("Name13", "Description13", 13000, 1300, 13, "history13", "link13", "questions13"));
		return projectStorage;
	}
	
}	
	
