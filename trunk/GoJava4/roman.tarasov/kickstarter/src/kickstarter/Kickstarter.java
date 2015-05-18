package kickstarter;


import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.pages.CategoriesPage;
import kickstarter.pages.DetailedProject;
import kickstarter.pages.Page;
import kickstarter.pages.ProjectsPage;
import kickstarter.pages.TheEndPage;
import kickstarter.pages.WrongChoicePage;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.QuotesRepository;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.UserInterface;

public class Kickstarter {

	QuotesRepository quotes;
	CategoriesRepository categories;
	ProjectRepository projects;
	Model model;
	View view;
	public Controller controller;
	UserInterface ui;
	CommentsRepository allComments;

	public Kickstarter() {
		allComments = new CommentsRepository();
		quotes = new QuotesRepository();
		projects = new ProjectRepository();

		categories = new CategoriesRepository();
		ui = new ConsoleUI();
		model = new Model();
		view = new View(model, ui);
		controller = new Controller(model, view);
		Page page = new CategoriesPage(categories, quotes, model);
		page.pageId = 0;
		controller.addPage(page);
		controller.setPage(0);
		page = new ProjectsPage(projects, model);
		controller.addPage(page);
		page = new DetailedProject(allComments, projects, model);
		controller.addPage(page);
		page = new WrongChoicePage(model);
		controller.addPage(page);
		page = new TheEndPage();
		controller.addPage(page);
	}

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.run();
	}

	public void testUI(UserInterface ui) {
		this.ui = ui;
	}

	private void run() {
		String command = null;

		while (true) {
			controller.printView();
			command = ui.inputString();
			controller.executeCommand(command);
		}
	}

}
