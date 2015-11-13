package ua.com.goit.gojava7.kickstarter.manager;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class CategoryManager {

	private ConsoleScanner consoleScanner;
	private CategoryStorage categoryStorage;

	private String BORDER = "\n________________________________________________________";
	private int SHIFT_ONE = 1;
	private int FIRST = 1;

	public CategoryManager(ConsoleScanner consoleScanner) {
		this.consoleScanner = consoleScanner;
		categoryStorage = initCategories();
	}

	public Integer chooseCategory() {
		System.out.println(BORDER);
		System.out.println("\nList of categories:");
		printCategories(categoryStorage.getAll());
		System.out.println("\nChoose a category by number (0 for exit): ");
		
		Integer selectedCategory = consoleScanner.getInteger(FIRST, categoryStorage.size());
		if (selectedCategory == null) {
			consoleScanner.close();
			System.out.println("See you soon!");
			System.exit(0);
		}
		return selectedCategory;
	}

	public Integer chooseProject(Integer selectedCategory) {
		System.out.println(BORDER);
		System.out.println("Current category N: " + selectedCategory + "("
				+ categoryStorage.get(selectedCategory - SHIFT_ONE).getName() + ")");
		System.out.println("List of projects:");
		printProjects(categoryStorage.get(selectedCategory - SHIFT_ONE).getAll());
		System.out.println("\nChoose a project by number (first to choose another category): ");
		Integer selectedProject = consoleScanner.getInteger(FIRST,
				categoryStorage.get(selectedCategory - SHIFT_ONE).size());
		if (selectedProject == null) {
			return null;
		}
		return selectedProject;
	}

	public void viewProject(Integer selectedCategory, Integer selectedProject) {
		System.out.println(BORDER);
		System.out.println("Current project: #" + (selectedProject));
		System.out.println("Current category: " + categoryStorage.get(selectedCategory - 1).getName() + "\n");
		ProjectManager projectManager = new ProjectManager(
				categoryStorage.get(selectedCategory - 1).get(selectedProject - 1), consoleScanner);
		projectManager.printFull();		
		String text = consoleScanner.getBackOrZero();
		if(text.equals("b")) System.out.println("\nyou have typed b");
	}

	public void printCategories(List<Category> categories) {
		for (int i = 0; i < categories.size(); i++) {
			System.out.println(i + 1 + ": " + categories.get(i).getName());
		}
	}

	public void printProjects(List<Project> projects) {
		for (int i = 0; i < projects.size(); i++) {
			System.out.println("\n" + (i + 1) + ":");
			ProjectManager projectManager = new ProjectManager(projects.get(i), consoleScanner);
			projectManager.printShort();
		}
	}

	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.add(initMusicCategory());
		categoryStorage.add(initDancesCategory());
		categoryStorage.add(initFoodCategory());
		return categoryStorage;
	}

	private static Category initMusicCategory() {
		Category category = new Category("Music");
		category.add(new Project("The Cookie Counter: vegan bakery, espresso bar, & ice cream!",
				"Seattle's first 100% plant based ice cream truck is ready for a shop "
						+ "of its own! Serving organic treats & espresso, all made with love.",
				31000, 3100, 31,
				"Add any of the amounts listed below to any LOCAL pledge level and "
						+ "you will get pints of our EXCLUSIVE Kickstarter flavor! Didn't "
						+ "back the Kickstarter and do an add-on? Sorry! This is gonna "
						+ "be an insanely yummy flavor, so don't miss out! If you like it "
						+ "a whole lot, we'll add it to our permanent rotation at a later "
						+ "date AND you get to vote on the name!",
				"There is no video", "No questions at the moment"));
		category.add(new Project("Name32", "Description32", 32000, 3200, 32, "history32", "link32", "questions32"));
		category.add(new Project("Name33", "Description33", 33000, 3300, 33, "history33", "link33", "questions33"));
		return category;
	}

	private static Category initDancesCategory() {
		Category category = new Category("Dances");
		category.add(new Project("Shift the Grid presents Vacancy",
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
						+ "\n     together as 6 choreographers, honoring each voice and " + "\n     body in the room. ",
				"https://d2pq0u4uni88oo.cloudfront.net/projects/2153340/video-600743-h264_high.mp4",
				"No questions at the moment"));
		category.add(new Project("Name22", "Description22", 22000, 2200, 22, "history22", "link22", "questions22"));
		category.add(new Project("Name23", "Description23", 23000, 2300, 23, "history22", "link22", "questions22"));
		return category;
	}

	private static Category initFoodCategory() {
		Category category = new Category("Food");
		category.add(new Project("'Critical Mass': New solo music from Jerry Chamberlain!",
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
		category.add(new Project("Name12", "Description12", 12000, 1200, 12, "history12", "link12", "questions12"));
		category.add(new Project("Name13", "Description13", 13000, 1300, 13, "history13", "link13", "questions13"));
		return category;
	}

}
