package ua.com.goit.gojava7.kikstarter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.dao.memory.QuoteDaoMemory;
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Project;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class KikstarterRunner {

	public static void main(String[] args) throws IOException {
		QuoteDaoMemory quoteDaoMemory = initQuotes();
		CategoryStorage categoryStorage = initCategories();
		ConsoleReader consoleReader = new ConsoleReader();
		ConsolePrinter consolePrinter = new ConsolePrinter();

		Kikstarter kikstarter = new Kikstarter(consoleReader, consolePrinter, quoteDaoMemory,
				categoryStorage);

		kikstarter.startUp();

	}

	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();
		Category category1 = new Category("Photography");
		Category category2 = new Category("Movie");
		Category category3 = new Category("Recording sound");

		categoryStorage.setCategory(category1);
		categoryStorage.setCategory(category2);
		categoryStorage.setCategory(category3);

		List<Project> projectsList = initProjects();

		category1.setProject(projectsList.get(0));
		category1.setProject(projectsList.get(3));
		category2.setProject(projectsList.get(1));
		category2.setProject(projectsList.get(4));
		category3.setProject(projectsList.get(2));

		return categoryStorage;
	}

	private static List<Project> initProjects() {
		List<Project> projectsList = new ArrayList<>();

		Project project1 = new Project("Portraits & Stories, 1989–1998", 35500, 12000, 28);
		project1.setProjectDescription("A photobook of B&W photography by Bill Bytsura documenting"
				+ " the people and stories behind the AIDS activist movement between 1989–1998.");
		project1.setProjectDetailedDescription("I’m a photographer who’s lived in NYC for over three decades. "
				+ "This book is the result of nearly ten years of work on the front lines of the AIDS activist movement. "
				+ "It’s my personal testimony and a tribute to the beautiful souls who paved the way"
				+ " for medical research, education, acceptance and human rights as it stands today. "
				+ "I’m really proud of this collection and hope that you’ll be moved by the pictures, "
				+ "the stories and the memory of so many fearless, radical individuals.");
		project1.setProjectUrl("https://www.kickstarter.com/projects/aidsactivistproject/the-aids-activist-project-portraits-and-stories-19?ref=category_featured");

		Project project2 = new Project("Poughkeepsie", 35000, 4885, 27);
		project2.setProjectDescription("A dying Alzheimer's patient believes he has the ability"
				+ " to travel back in time and tries to rewrite his past before time runs out.");
		project2.setProjectDetailedDescription("Poughkeepsie is a 20-minute short film about George Dawes, "
				+ "a late-stage Alzheimer’s patient facing his final days with a fractured sense of reality and a heart full of regrets. "
				+ "He is haunted by a terrible marriage, the death of his daughter and "
				+ "his subsequent bad parenting of his granddaughter, Elaine. His final days look bleak.");
		project2.setProjectUrl("https://www.kickstarter.com/projects/1749833744/poughkeepsie-a-short-film?ref=category_recommended");

		Project project3 = new Project("HELP BRING BACK GOOD MUSIC!", 7500, 845, 25);
		project3.setProjectDescription("In this exciting project, we will be building a brand"
				+ " new recording studio from the ground up for everyone to enjoy!");
		project3.setProjectDetailedDescription("THE VISION - Construct one of the best recording studios in the area where some amazing music can be created. "
				+ "I am very adamant about wanting to change the future of music as well as raise awareness among aspiring artists "
				+ "on what the condition of the music industry is and what to do and not to do from my 19 years of experience. "
				+ "Originality has been lost and the \"art\" of music is blurry in today's music industry. "
				+ "I feel this studio can have a major impact on the future of music to make a positive change.");
		project3.setProjectUrl("https://www.kickstarter.com/projects/1285390802/help-bring-back-good-music-recording-studio-build?ref=nav_search");

		Project project4 = new Project("A Thousand Dawns: Worldcycle Story & Photobook", 15000,
				12161, 7);
		project4.setProjectDescription("A 40,000km, 4 year journey by bicycle around the world, told through tales of adventure & photography.");
		project4.setProjectDescription("That's right. The world. The whole globe. By bicycle.A journey full circle from London to London on two wheels. "
				+ "A photographic adventure and a universal story about the need for change, creativity & happiness..."
				+ "Inspired by books such as Wild, A Thousand Dawns chronicles a ride across the earth and a journey into the depths of the mind. "
				+ "Weaving tales of childhood and the struggles of adolescence into the story of over a thousand days lived in the saddle. "
				+ "A book full of wonder, revelations, fears and acceptance: for who we are and what we can achieve.");
		project4.setProjectUrl("https://www.kickstarter.com/projects/roblutter/a-thousand-dawns-the-lifecycle-story-and-photobook?ref=category_popular");

		Project project5 = new Project("Of Woman And Earth Documentary", 10000, 4527, 5);
		project5.setProjectDescription("A story from the roof of the world, documenting the last generation of Ladakhi nomads living in the Tibetan Plateau.");
		project5.setProjectDetailedDescription("Set against the wild majesty of the Himalayas in the Indian province of Ladakh, "
				+ "Of Woman And Earth tells of the trials, tribulation and triumph of three elderly nomadic women whose "
				+ "life stories have unfolded in The Tibetan Plateau. With themes that explore spirituality and women’s "
				+ "roles within the nomadic community, the film progresses in the harsh landscape and with rapidly changing "
				+ "climatic conditions and cultural changes spurred by modernisation. ");
		project5.setProjectUrl("https://www.kickstarter.com/projects/285884784/of-woman-and-earth-documentary?ref=category_featured");

		projectsList.add(project1);
		projectsList.add(project2);
		projectsList.add(project3);
		projectsList.add(project4);
		projectsList.add(project5);

		return projectsList;
	}

	private static QuoteDaoMemory initQuotes() {
		QuoteDaoMemory quoteDaoMemory = new QuoteDaoMemory();

		Quote quote1 = new Quote("Two things are infinite: the universe and human stupidity and I'm not sure about the universe.","Albert Einstein");

		Quote quote2 = new Quote("Coming together is a beginning; keeping together is progress; working together is success.","Henry Ford");
		
		Quote quote3 = new Quote("Mistakes are always forgivable, if one has the courage to admit them.","Bruce Lee");

		Quote quote4 = new Quote("Give me six hours to chop down a tree and I will spend the first four sharpening the axe.","Abraham Lincoln");

		quoteDaoMemory.add(quote1);
		quoteDaoMemory.add(quote2);
		quoteDaoMemory.add(quote3);
		quoteDaoMemory.add(quote4);

		return quoteDaoMemory;
	}

}
