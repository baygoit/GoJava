package kickstarter;

import kickstarter.entities.Category;
import kickstarter.entities.Comments;
import kickstarter.entities.Project;
import kickstarter.entities.Quote;
import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.pages.CategoriesPage;
import kickstarter.pages.DetailedProject;
import kickstarter.pages.Page;
import kickstarter.pages.ProjectsPage;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.UserInterface;

public class Kickstarter {
	Storage<Category> categories;
	Storage<Project> projects;
	Storage<Comments> allComments;
	Storage<Quote> quotes;
	Model model;
	View view;
	public Controller controller;
	UserInterface ui;

	public Kickstarter() {
		categories = new EntityStorage<Category>();
		projects = new EntityStorage<Project>();
		allComments = new EntityStorage<Comments>();
		quotes = new EntityStorage<Quote>();
		ui = new ConsoleUI();
		model = new Model(ui);
		view = new View(model, ui);
		controller = new Controller(model, view);
	}

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.load();
		kickstarter.run();
	}

	public void testUI(UserInterface ui) {
		this.ui = ui;
	}

	private void run() {
		String command;
		while (true) {
			controller.printView();
			command = ui.inputString();
			controller.executeCommand(command);
		}
	}

	public void testLoadQuote(String stringToQuote) {
		Quote quote = new Quote();
		quote.setQuote(stringToQuote);
		quotes.add(quote);
	}

	public void testLoadComments() {
		Category category = new Category("test comments");
		Project project = new Project("test comments", category);
		Comments comments = new Comments(project);
		for (int number = 0; number < 30; number++) {
			comments.addComment(1, "comment");
		}
	}

	public void load() {

		Quote quote = new Quote();
		quote.setQuote("Explore projects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);

		Category category;

		Page page = new CategoriesPage(categories, ui, quotes);
		page.pageId = 0;
		controller.addPage(page);
		controller.setPage(0);

		Project project;
		category = new Category("Social");
		category.ID = 4;
		categories.add(category);

		project = new Project("Paint the fence of the school", category);
		project.description = "raising money for paint";
		project.ID = 8;
		projects.add(project);
		Comments comments = new Comments(project);
		comments.addComment(1, "What color will paint?");
		comments.addComment(2, "Paint is Green");
		allComments.add(comments);

		category = new Category("Technology");
		category.ID = 5;
		categories.add(category);

		project = new Project("Create electrobike", category);
		project.description = "high efficiency";
		project.shortDescription = "short description";
		project.history = "history of bike creation";
		project.linkToVideo = "www.link.to.demo.video";
		project.pledged = 25;
		project.goal = 2000;
		project.ID = 23;
		projects.add(project);
		comments = new Comments(project);
		comments.addComment(3, "how much weight the bike?");
		comments.addComment(2, "The weight of bike is 15 kilo");
		allComments.add(comments);

		project = new Project("Create quadrocopter", category);
		project.ID = 4;
		projects.add(project);

		page = new ProjectsPage(projects, ui);
		controller.addPage(page);
		page = new DetailedProject(ui, allComments, projects);
		controller.addPage(page);
	}
}
