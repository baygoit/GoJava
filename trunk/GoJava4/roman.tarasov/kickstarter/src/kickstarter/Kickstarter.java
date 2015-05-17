package kickstarter;

import kickstarter.entities.QuestionsAndAnswers;

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
import kickstarter.repository.EntityStorage;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.QuotesRepository;
import kickstarter.repository.Storage;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.UserInterface;

public class Kickstarter {

	Storage<QuestionsAndAnswers> allComments;

	QuotesRepository quotes;
	CategoriesRepository categories;
	ProjectRepository projects;
	Model model;
	View view;
	public Controller controller;
	UserInterface ui;

	public Kickstarter() {
		quotes = new QuotesRepository();
		projects = new ProjectRepository();
		allComments = new EntityStorage<QuestionsAndAnswers>();
		categories = new CategoriesRepository();
		ui = new ConsoleUI();
		model = new Model();
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
		String command = null;

		while (true) {
			controller.printView();
			command = ui.inputString();
			controller.executeCommand(command);
		}
	}

	public void load() {

		Page page = new CategoriesPage(categories, quotes, model);
		page.pageId = 0;
		controller.addPage(page);
		controller.setPage(0);
		page = new ProjectsPage(projects, model);
		controller.addPage(page);
		page = new DetailedProject(allComments, projects);
		controller.addPage(page);
		page = new WrongChoicePage();
		controller.addPage(page);
		page = new TheEndPage();
		controller.addPage(page);
	}
}
