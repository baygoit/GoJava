package com.gojava2.kickstarter.controller;

import java.util.Random;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.CategoryStorageInVM;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.ProjectStorageInVM;
import com.gojava2.kickstarter.model.Quote;
import com.gojava2.kickstarter.model.QuoteStorageInVM;
import com.gojava2.kickstarter.view.ConsoleInput;
import com.gojava2.kickstarter.view.ConsoleView;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorageInVM quoteStorage = new QuoteStorageInVM(new Random());
		CategoryStorageInVM categoryStorage = new CategoryStorageInVM();
		ProjectStorageInVM projectStorageInVM = new ProjectStorageInVM();
		
		quoteStorage.addQuote(new Quote("Sometimes when you innovate, you make mistakes."
				+ "\n It is best to admit them quickly, and get on with\n improving your other innovations.", "Steve Jobs"));
		quoteStorage.addQuote(new Quote("Sometimes when you innovate, you make mistakes."
				+ "\n It is best to admit them quickly, and get on with\n improving your other innovations.", "Steve Jobs"));
		quoteStorage.addQuote(new Quote("The common question that gets asked in business is, 'why?'."
				+ "\n That's a good question, but an equally valid question is, 'why not?'", "Jeff Bezos"));
		quoteStorage.addQuote(new Quote("If there is anything that a man can do well,\n I say let him do it. Give him a chance.", "Abraham Lincoln"));
		quoteStorage.addQuote(new Quote("Great leaders, like Steve Jobs or Jeff Bezos, also focused on the long term.", "Reed Hastings"));
		quoteStorage.addQuote(new Quote("When you're curious, you find lots of interesting things to do.", "Walt Disney"));
		
		Category category1 = new Category("Art");
		Category category2 = new Category("Comics");
		Category category3 = new Category("Dance");
		
		categoryStorage.addCategory(category1);
		categoryStorage.addCategory(category2);
		categoryStorage.addCategory(category3);
		
		
		Category category4 = new Category("Gamse");
		categoryStorage.addCategory(category4);
		
		Project project1 = new Project("NY artists", "Some description.", 10000, 200, 25, 1,
				"There'll be history", "http://www.nyart.com");
		Project project2 = new Project("The observatory", "Little observatory.", 2000, 100, 17, 1,
				"There'll be history", "http://www.observatory.com");
		Project project3 = new Project("The sing for hope pianos", "The pianos who play in the streat.",
				15000, 5000, 4, 30, "There'll be history", "http://www.pianos.com");
		Project project4 = new Project("Super Man", "Comic about a man having super powers.",
				50000, 1000, 15, 5, "There'll be history", "http://www.superman.com");
		Project project5 = new Project("Hulk", "Comics on the green hero named Hulk.", 
				20000, 100, 50, 2,"There'll be history", "http://www.hulk.com");
		Project project6 = new Project("Spider man", "Little - little spider man.", 4000, 200,
				40, 1,"There'll be history", "http://www.spiderman.com");
		Project project7 = new Project("Dance & Fly", "You can dance, you can fly, we belive in you!",
				5000, 1000, 15, 7, "There'll be history", "http://www.df.com");
		Project project8 = new Project("Tiny Epic Galaxies", "Develop your empire and "
				+ "colonize planets to create the most powerful galaxy!",
				100000, 30000, 50, 17, "There'll be history", "http://www.galaxies.com");
		Project project9 = new Project("Shadowrun: Hong Kong", "A Shadowrun cyberpunk cRPG "
				+ "set in 2056's Magically Awakened Hong Kong by the developers of "
				+ "Shadowrun Returns & Dragonfall.",
				30000, 2000, 33, 10, "There'll be history", "http://www.shadowrun.com");
		Project project10 = new Project("Starr Mazer", "A retro-sexy Point-and-Click Adventure "
				+ "Shoot 'em Up in SPACE!", 50000, 3000, 20, 6, "There'll be history", 
				"http://www.starr mazer.com");
		
		project1.setCategory(category1);
		project2.setCategory(category1);
		project3.setCategory(category1);
		
		project4.setCategory(category2);
		project5.setCategory(category2);
		project6.setCategory(category2);
		
		project7.setCategory(category3);
		
		project8.setCategory(category4);
		project9.setCategory(category4);
		project10.setCategory(category4);
		
		projectStorageInVM.addProject(project1);
		projectStorageInVM.addProject(project2);
		projectStorageInVM.addProject(project3);
		projectStorageInVM.addProject(project4);
		projectStorageInVM.addProject(project5);
		projectStorageInVM.addProject(project6);
		projectStorageInVM.addProject(project7);
		projectStorageInVM.addProject(project8);
		projectStorageInVM.addProject(project9);
		projectStorageInVM.addProject(project10);
		
		KickstarterController app = new KickstarterController(quoteStorage, categoryStorage,
																projectStorageInVM, new ConsoleView(),
																new ConsoleInput());
		app.run();
	}
}