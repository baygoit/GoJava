package Runner;

import kickstarter.Kickstarter;
import kickstarter.Entities.Category;
import kickstarter.Entities.Project;
import kickstarter.Entities.Quote;
import kickstarter.Repository.EntityStorage;
import kickstarter.Repository.Storage;

public class KickstarterRun {
	Kickstarter kickstarter;

	public static void main(String[] args) {
		KickstarterRun runner = new KickstarterRun();
		Kickstarter kickstarter = new Kickstarter();
		Storage<Category> categories = new EntityStorage<Category>();
		Storage<Project> projects = new EntityStorage<Project>();

		Storage<Quote> quotes = new EntityStorage<Quote>();
		runner.createQuotes(quotes);

		Project project;
		Category category = new Category("Social");
		category.id = 2;
		categories.add(category);

		project = new Project("Paint the fence of the school", category);
		project.description = "raising money for paint";
		project.id = 8;
		projects.add(project);

		category = new Category("Technology");
		category.id = 5;
		categories.add(category);

		project = new Project("Create electrobike", category);
		project.description = "high efficiency";
		project.history = "history of bike creation";
		project.pledged = 25;
		project.goal = 2000;
		project.id = 23;
		projects.add(project);

		project = new Project("Create quadrocopter", category);
		project.id = 4;
		projects.add(project);

		/*
		 * category = new Category("Technology"); kickstarter.add(category);
		 * project = new Project("Create quadrocopter", category);
		 * kickstarter.add(project);
		 */
		kickstarter.addCategories(categories);
		kickstarter.addProjects(projects);
		kickstarter.add(quotes);
		kickstarter.start();
	}

	void createQuotes(Storage<Quote> quotes) {
		Quote quote = new Quote();
		quote.setQuote("first quote");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("second quote");
		quotes.add(quote);
	}
}
