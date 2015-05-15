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
//Start MVC architecture
public class Kickstarter {
	Storage<Category> categories;
	Storage<Project> projects;
	Storage<Comments> allComments;
	Storage<Quote> quotes;
	Model model;
	View view;
	Controller controller;
	UserInterface ui;

	Kickstarter() {
		categories = new EntityStorage<Category>();
		projects = new EntityStorage<Project>();
		allComments = new EntityStorage<Comments>();
		quotes = new EntityStorage<Quote>();
		model = new Model();
		view = new View(model);
		controller = new Controller(model, view);
		ui = new ConsoleUI();
	}

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.load();
		kickstarter.run();
	}

	private void run() {
		String command;
		while (true) {
			controller.printView();
			command = ui.inputString();
			controller.executeCommand(command);
		}
	}

	void load() {

		Quote quote = new Quote();
		quote.setQuote("first quote");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("second quote");
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
