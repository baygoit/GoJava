package goit.nz.kickstartermvc;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.Quote;
import goit.nz.kickstartermvc.input.Input;
import goit.nz.kickstartermvc.output.Output;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {
	private static Kickstarter app;
	private static DataStorage storage;
	private static Input input;
	private static Output output;

	public static void main(String[] args) {
		input = new Input();
		output = new Output();
		storage = new DataStorage();
		prepareData(storage);
		app = new Kickstarter(storage, output, input);
		app.run();
	}

	public static void prepareData(DataStorage storage) {
		loadQuotes(storage);
		loadCategories(storage);
		loadProjects(storage);
	}

	private static void loadProjects(DataStorage storage) {
		List<Project> projects = new ArrayList<>();
		List<Category> categories = storage.getCategories();
		Project p1 = new Project("name1", "desc1", 1000, 0, 10);
		Project p2 = new Project("name2", "desc2", 10000, 100, 90);
		Project p3 = new Project("name3", "desc3", 100, 90, 15);
		Project p4 = new Project("name4", "desc4", 100000, 50000, 100);
		p1.setCategory(categories.get(1));
		p2.setCategory(categories.get(3));
		p3.setCategory(categories.get(2));
		p4.setCategory(categories.get(3));
		Project p5 = new Project("Empty project");
		p5.setCategory(categories.get(3));
		p1.setEvents("We have almost finished!\nWe are going to start!");
		p1.setLink("http://www.youtube.com/jrgri74ht3h97");
		p1.setFAQ("How can you imagine such idea?\nBecause of whisky, babe!");
		p2.setEvents("Blah-blah-blah-blah...");
		projects.add(p1);
		projects.add(p2);
		projects.add(p3);
		projects.add(p4);
		projects.add(p5);
		storage.registerProjects(projects);
	}

	private static void loadQuotes(DataStorage storage) {
		List<Quote> quotes = new ArrayList<>();
		Quote q1 = new Quote(
				"\"Start by doing what's necessary; then do what's possible; "
						+ "and suddenly you are doing the impossible.\"",
				"Francis of Assisi");
		Quote q2 = new Quote(
				"\"The best and most beautiful things in the world cannot be seen or even touched "
						+ "- they must be felt with the heart.\"",
				"Helen Keller");
		Quote q3 = new Quote(
				"\"I can't change the direction of the wind, "
						+ "but I can adjust my sails to always reach my destination.\"",
				"Jimmy Dean");
		Quote q4 = new Quote("Test Quote");
		quotes.add(q1);
		quotes.add(q2);
		quotes.add(q3);
		quotes.add(q4);
		storage.registerQuotes(quotes);
	}

	private static void loadCategories(DataStorage storage) {
		List<Category> categories = new ArrayList<>();
		Category cat1 = new Category("Art");
		Category cat2 = new Category("Comics");
		Category cat3 = new Category("Crafts");
		Category cat4 = new Category("Games");
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);
		categories.add(cat4);
		storage.registerCategories(categories);
	}

}
