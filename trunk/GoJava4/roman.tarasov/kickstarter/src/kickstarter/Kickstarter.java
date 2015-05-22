package kickstarter;

import kickstarter.entities.ProjectComments;
import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.pages.model.ApplyM;
import kickstarter.pages.model.CategoriesM;
import kickstarter.pages.model.CommentM;
import kickstarter.pages.model.DetailedM;
import kickstarter.pages.model.DonateM;
import kickstarter.pages.model.InvestM;
import kickstarter.pages.model.ProjectsM;
import kickstarter.pages.model.ResultOfBankM;
import kickstarter.pages.model.TheEndM;
import kickstarter.pages.model.WrongM;
import kickstarter.pages.model.PageModel;
import kickstarter.pages.view.ApplyTransaction;
import kickstarter.pages.view.Categories;
import kickstarter.pages.view.Comment;
import kickstarter.pages.view.DetailedProject;
import kickstarter.pages.view.Donate;
import kickstarter.pages.view.Invest;
import kickstarter.pages.view.PageView;
import kickstarter.pages.view.Projects;
import kickstarter.pages.view.ResultOfBankOperation;
import kickstarter.pages.view.TheEnd;
import kickstarter.pages.view.WrongChoice;
import kickstarter.payment.Bank;
import kickstarter.repository.fasade.Repository;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.iUserInterface;

public class Kickstarter {

	ProjectComments projectComments;
	private View view;
	private Model model;
	public Controller controller;
	private iUserInterface ui;

	private Repository repository;
	private Bank bank;

	public Kickstarter() {
	}

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.init();
		kickstarter.run();
	}

	public void init() {

		repository = new Repository();
		bank = new Bank();

		model = new Model();
		ui = new ConsoleUI();
		view = new View(model, ui);
		controller = new Controller(view, model);
		viewInit();
		modelInit();

	}

	private void modelInit() {
		PageModel pageModel = new CategoriesM(model);
		model.addPageModel(pageModel);

		pageModel = new ProjectsM(model);
		model.addPageModel(pageModel);

		pageModel = new DetailedM(model);
		model.addPageModel(pageModel);

		pageModel = new WrongM(model);
		model.addPageModel(pageModel);

		pageModel = new TheEndM(model);
		model.addPageModel(pageModel);

		pageModel = new CommentM(repository, model);
		model.addPageModel(pageModel);

		pageModel = new InvestM(repository, model);
		model.addPageModel(pageModel);

		pageModel = new DonateM(bank, repository, model);
		model.addPageModel(pageModel);

		pageModel = new ResultOfBankM(model);
		model.addPageModel(pageModel);

		pageModel = new ApplyM(bank, repository, model);
		model.addPageModel(pageModel);

	}

	private void viewInit() {

		PageView pageView = new Categories(repository, model);
		view.addPageView(pageView);

		pageView = new Projects(repository, model);
		view.addPageView(pageView);

		pageView = new DetailedProject(repository, model);
		view.addPageView(pageView);

		pageView = new WrongChoice();
		view.addPageView(pageView);

		pageView = new TheEnd();
		view.addPageView(pageView);

		pageView = new Comment(repository, model);
		view.addPageView(pageView);

		pageView = new Invest(repository, model);
		view.addPageView(pageView);

		pageView = new Donate(bank, repository, model);
		view.addPageView(pageView);

		pageView = new ResultOfBankOperation(model);
		view.addPageView(pageView);

		pageView = new ApplyTransaction();
		view.addPageView(pageView);
	}

	public void testUI(iUserInterface ui) {
		this.ui = ui;
	}

	private void run() {
		String command = null;

		while (true) {
			controller.printView();
			command = ui.inputString();
			controller.update(command);
		}
	}
}
