package ua.com.gojava4.kickstarter.model.repositories;

import java.util.ArrayList;
import java.util.List;

import ua.com.gojava4.kickstarter.entities.Quote;
import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Project;

public class SimpleRepositoryFactory extends AbstractRepositoryFactory {
	
	private List<Quote> quotes;
	private List<Category> categories;
	private List<Project> projects;
	
	public SimpleRepositoryFactory (String factoryType){
		switch (factoryType.toLowerCase()) {
		case "quotes":
			initializeQuotes();
			break;
			
		case "categories":
			initializeCategories();
			break;
			
		case "projects":
			initializeProjects();
			break;

		default:
			break;
		}		
	}

	private void initializeQuotes() {
		quotes = new ArrayList<Quote>();
		quotes.add(new Quote(
				"Life isn't about finding yourself. Life is about creating yourself.",
				"\n(c)Author"));
		quotes.add(new Quote(
				"Start by doing what's necessary; then do what's possible and \nsuddenly you are doing the impossible.",
				"(c)Author"));
		quotes.add(new Quote(
				"You have to learn the rules of the game. And then you have to \nplay better than anyone else.",
				"(c)Author"));
		quotes.add(new Quote(
				"Perfection is not attainable, but if we chase perfection we can \ncatch excellence.",
				"(c)Author"));
		quotes.add(new Quote(
				"My favorite things in life don't cost any money. It's really clear\n that the most precious resource we all have is time.",
				"(c)Author"));		
	}

	private void initializeCategories() {
		categories = new ArrayList<Category>();
		categories.add(new Category(1, "Design"));
		categories.add(new Category(2, "Technology"));
	}

	private void initializeProjects() {
		projects = new ArrayList<Project>();
		projects.add(new Project(
				"SNAP",
				"Design Your Own Furniture",
				15000,
				27000,
				30,
				"With SNAP you can create endless solutions for your living space. You can "
						+ "transform any surface into a unique piece of furniture.",
				"http://www.youtube.com/01",
				"How do I choose the color combination?", 1, 1));
		projects.add(new Project("HYDAWAY",
				"A Pocket-Sized Water Bottle Fit for any Adventure", 20000,
				181437, 3,
				"HYDAWAY is a handy alternative to disposable plastic water bottles - it folds"
						+ "down easily to fit in almost any pocket!",
				"http://www.youtube.com/0143534",
				"How much is the bottle weight", 1, 2));
		projects.add(new Project(
				"DASH 4.0 WALLET",
				"A Minimal Wallet Redefined",
				5000,
				46848,
				52,
				"The ORIGINAL quickdraw wallet for minimalists. Carry the things you need, and "
						+ "access them easily.",
				"http://www.youtube.com/0143534",
				"What are the dimensions of the wallet?",
				1, 3));
		projects.add(new Project(
				"USB CHARGEDOUBLER",
				"Double your charging speed!",
				2750,
				2140,
				32,
				"THE ORIGINAL Up to 200% charging speed for iPhone & Android. No data theft. "
						+ "The magnetic usb cable for your keyring.",
				"http://www.youtube.com/0143534", "Have a question?",
				1, 4));

		projects.add(new Project(
				"FIREFLY HAND",
				"Light up your life",
				3500,
				470,
				25,
				"FireFly Hand is the next generation electric "
						+ "flashlight, which is capable of making your life significantly easier.​",
				"http://www.youtube.com/0143534", "Have a question?",
				2, 1));
		projects.add(new Project(
				"CUBIT",
				"The Make Anything Platform",
				50000,
				169,
				34,
				"A platform that brings together plug & play hardware and drag & drop software "
						+ "to allow everyone to create and invent!",
				"http://www.youtube.com/0143534", "Have a question?",
				2, 2));
		projects.add(new Project(
				"NOKI",
				"The smart doorlock for Europe",
				125000,
				119082,
				44,
				"Noki is the first smart doorlock for Europe. It opens your door when you come "
						+ "home and locks it when you leave.",
				"http://www.youtube.com/031234", "Have a question?",
				2, 3));		
	}

	@Override
	public List<Quote> getAllQuotes() {
		return quotes;
	}
	
	@Override
	public List<Project> getAllProjects() {
		return projects;
	}
	
	@Override
	public List<Category> getAllCategories() {
		return categories;
	}	
}
