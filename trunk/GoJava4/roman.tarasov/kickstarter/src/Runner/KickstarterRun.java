package Runner;

import kickstarter.ConsoleUI;
import kickstarter.Kickstarter;
import kickstarter.UserInterface;
import kickstarter.Entities.Category;
import kickstarter.Entities.Comments;
import kickstarter.Entities.Project;
import kickstarter.Entities.Quote;
import kickstarter.Repository.EntityStorage;
import kickstarter.Repository.Storage;

public class KickstarterRun {
	static KickstarterRun runner;
	Kickstarter kickstarter;

	public static void main(String[] args) {
		runner = new KickstarterRun();
		runner.newKickstarter();
		runner.kickstarterLoader();
		runner.kickstarterStart(runner.kickstarterSetConsoleUi());
	}

	public void kickstarterTest() {
		//runner = new KickstarterRun();
		runner.newKickstarter();
		runner.kickstarterLoader();
	}

	UserInterface kickstarterSetConsoleUi() {
		return new ConsoleUI();
	}

	public void kickstarterStart(UserInterface userInterface) {
		kickstarter.start(userInterface);
	}

	public void newKickstarter() {
		kickstarter = new Kickstarter();
	}

	public void kickstarterLoader() {
		Storage<Category> categories = new EntityStorage<Category>();
		Storage<Project> projects = new EntityStorage<Project>();
		Storage<Quote> quotes = new EntityStorage<Quote>();
		Storage<Comments> allComments = new EntityStorage<Comments>();

		Quote quote = new Quote();
		quote.setQuote("first quote");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("second quote");
		quotes.add(quote);

		Project project;
		Comments comments;
		Category category = new Category("Social");
		category.id = 2;
		categories.add(category);

		project = new Project("Paint the fence of the school", category);
		project.description = "raising money for paint";
		project.id = 8;
		projects.add(project);
		comments = new Comments(project);
		comments.addComment(1, "What color will paint?");
		comments.addComment(2, "Paint is Green");
		allComments.add(comments);

		category = new Category("Technology");
		category.id = 5;
		categories.add(category);

		project = new Project("Create electrobike", category);
		project.description = "high efficiency";
		project.shortDescription = "short description";
		project.history = "history of bike creation";
		project.linkToVideo = "www.link.to.demo.video";
		project.pledged = 25;
		project.goal = 2000;
		project.id = 23;

		comments = new Comments(project);
		comments.addComment(3, "What a weight of bike?");
		comments.addComment(2, "The weight of bike is 15 kilo");
		allComments.add(comments);

		projects.add(project);

		project = new Project("Create quadrocopter", category);
		project.id = 4;
		projects.add(project);

		kickstarter.addCategories(categories);
		kickstarter.addProjects(projects);
		kickstarter.addQuotes(quotes);
		kickstarter.addAllComments(allComments);
	}
}
