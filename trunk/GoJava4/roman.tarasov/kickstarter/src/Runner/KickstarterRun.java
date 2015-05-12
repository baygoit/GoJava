package Runner;

import kickstarter.Kickstarter;
import kickstarter.Entities.Category;
import kickstarter.Entities.Project;
import kickstarter.Entities.Quote;
import kickstarter.Repository.CategoryList;
import kickstarter.Repository.EntityStorage;
import kickstarter.Repository.QuoteList;
import kickstarter.Repository.Storage;
import kickstarter.Repository.ProjectList;
//import kickstarter.Repository.QuoteList;

public class KickstarterRun {

	public static void main(String[] args) {

		Kickstarter kickstarter = new Kickstarter();
		CategoryList categories = new CategoryList();
		ProjectList projects = new ProjectList();
		Storage<Quote> quotes =new EntityStorage<Quote>();

		Quote quote = new Quote();
		quote.setQuote("first quote");
		quotes.add(quote);
		
		quote = new Quote();
		quote.setQuote("second quote");
		quotes.add(quote);
		
		Quote concrete =quotes.getEntity(0);
		System.out.println(concrete.getQuote());
		concrete =quotes.getEntity(1);
		System.out.println(concrete.getQuote());
		
		
		Project project;
		Category category = new Category("Social");
		category.id = 2;
		categories.addCategory(category);

		project = new Project("Paint the fence of the school", category);
		project.description = "raising money for paint";
		project.id = 8;
		projects.addProject(project);

		category = new Category("Technology");
		category.id = 5;
		categories.addCategory(category);

		project = new Project("Create electrobike", category);
		project.description = "high efficiency";
		project.history = "history of bike creation";
		project.pledged = 25;
		project.goal = 2000;
		project.id = 23;
		projects.addProject(project);

		project = new Project("Create quadrocopter", category);
		project.id = 4;
		projects.addProject(project);

		/*
		 * category = new Category("Technology"); kickstarter.add(category);
		 * project = new Project("Create quadrocopter", category);
		 * kickstarter.add(project);
		 */
		kickstarter.add(categories);
		kickstarter.add(projects);
		kickstarter.start();
	}
}
