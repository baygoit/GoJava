package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;

	private ConsolePrinter consolePrinter;
	private ConsoleInspector consoleInspector;
	
	Integer categoryNumber = null;
	Integer projectNumber = null;
	List<Category> categories;
	
	public Kickstarter(ConsolePrinter consolePrinter, ConsoleInspector consoleInspector,
			QuoteStorage quoteStorage, CategoryStorage categoryStorage, ProjectStorage projectStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleInspector = consoleInspector;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
	}

	//int selectedCategory;
			//do {
			//	System.out.println("");
			//	System.out.println(categories);
			//	System.out.println("Please select category (0 for exit): ");
			//	selectedCategory = consoleInspector.getCorrectInt(9);
	//
			//	if (selectedCategory < 0 || selectedCategory > categoryStorage.size()) {
			//		System.out.println("Please, enter the number between 0 and " + categoryStorage.size());
			//		continue;
			//	} else if (selectedCategory != 0) {
			//		System.out.println("You selected category number " + selectedCategory);
			//		System.out.println(categoryStorage.get(selectedCategory - 1));
			//	} else {
			//		System.out.println("You entered 0. Bye.");
			//	}
			//	// show selected category
			//} while(selectedCategory != 0 );
	
	public void run() {
		consolePrinter.print(quoteStorage.getRandomQuote());		
		
		
		categories = categoryStorage.get();
		categoryNumber = chooseCategory();		
		projectNumber = chooseProject(categoryNumber);
		viewProject(projectNumber);				
	}

	public Integer chooseCategory() {
		System.out.println("\nList of categories:");
		consolePrinter.printCategories(categories);
		System.out.println("\nChoose a category by number (0 for exit): ");				
		categoryNumber = consoleInspector.getCorrectInt(categoryStorage.size());
		if(categoryNumber == 0) {
			consoleInspector.close();		
			System.out.println("See you soon!");
			System.exit(0);
			}
		System.out.println("\n_______________________________________________________");		
		System.out.println("Current category: " + categoryStorage.get(categoryNumber - 1).getName());		
	return categoryNumber;			
	}
	
	private Integer chooseProject(Integer categoryNumber) {		
		System.out.println("List of projects:");
		if(categoryNumber == 1) {
			projectStorage = initMusicStorage();
		}	else if(categoryNumber == 2) {
			projectStorage = initDanceStorage();
		} else if(categoryNumber == 3) {
			projectStorage = initFoodStorage();
		}
		consolePrinter.printProjects(projectStorage.get());	
		System.out.println("\nChoose a project by number (0 for return to list of categories): ");	
		projectNumber = consoleInspector.getCorrectInt(projectStorage.size());		
		if(projectNumber == 0) {
			chooseProject(chooseCategory());
			}
		System.out.println("\n_______________________________________________________");	
		System.out.println("Current project number " + projectNumber + ": ");		
		return projectNumber -1;
	}
	
	private void viewProject(Integer projectNumber){		
		Project project = new Project();
		project =  projectStorage.get(projectNumber);
		consolePrinter.printFull(project);	
		while(true) {
			if (consoleInspector.getCorrectInt(0) == 0 ) {			
				viewProject(chooseProject(categoryNumber));												
			} 	
		System.out.println("Type 0 to choose another project");
		}
	}
	
	public void shutdown() {
		consoleInspector.close();
	}
	

	private static ProjectStorage initFoodStorage() {
		ProjectStorage projectStorage = new ProjectStorage();
		projectStorage.add(new Project(
				"The Cookie Counter: vegan bakery, espresso bar, & ice cream!", 
				"Seattle's first 100% plant based ice cream truck is ready for a shop "
				+ "of its own! Serving organic treats & espresso, all made with love.", 
				31000, 3100, 31, 
				"Add any of the amounts listed below to any LOCAL pledge level and "
				+ "you will get pints of our EXCLUSIVE Kickstarter flavor! Didn't "
				+ "back the Kickstarter and do an add-on? Sorry! This is gonna "
				+ "be an insanely yummy flavor, so don't miss out! If you like it "
				+ "a whole lot, we'll add it to our permanent rotation at a later "
				+ "date AND you get to vote on the name!", 
				"There is no video", 
				"No questions at the moment"));
		projectStorage.add(new Project("Name32", "Description32", 32000, 3200, 32, "history32", "link32", "questions32"));
		projectStorage.add(new Project("Name33", "Description33", 33000, 3300, 33, "history33", "link33", "questions33"));
		return projectStorage;
	}
	
	private static ProjectStorage initDanceStorage() {
		ProjectStorage projectStorage = new ProjectStorage();
		projectStorage.add(new Project(
				"Shift the Grid presents Vacancy", 
				"Vacancy: A contemporary dance performance produced collaboratively "
				+ "\n     by 6 minds exploring what it feels like to be in two places at once. ", 
				21000, 2100, 21, 
				"So we embarked on the impossible. Collaborating with the usual "
				+ "\n     six minds in the room, and bringing in three more to the mix, "
				+ "\n     over the past six months. Shift the Grid is coming up on it’s "
				+ "\n     year anniversary and has been selected as the resident artist "
				+ "\n     for Motion Pacific’s Incubator project. We are honored and "
				+ "\n     lucky to have the opportunity as an incredibly young collective, "
				+ "\n     to embark on the journey of putting on our own evening lengths "
				+ "\n     work. We are so EXCITED!! And nervous, and unsure and "
				+ "\n     completely making things up as we go along. The aim of "
				+ "\n     the project is to explore our curiosities through contemporary "
				+ "\n     dance, and work in a truly collaborative process in doing so. "
				+ "\n     We wanted to push ourselves to make the entirety of our show "
				+ "\n     together as 6 choreographers, honoring each voice and "
				+ "\n     body in the room. ", 
				"https://d2pq0u4uni88oo.cloudfront.net/projects/2153340/video-600743-h264_high.mp4", 
				"No questions at the moment"));
		projectStorage.add(new Project("Name22", "Description22", 22000, 2200, 22, "history22", "link22", "questions22"));
		projectStorage.add(new Project("Name23", "Description23", 23000, 2300, 23, "history22", "link22", "questions22"));
		return projectStorage;
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


