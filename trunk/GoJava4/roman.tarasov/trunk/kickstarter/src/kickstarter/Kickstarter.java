package kickstarter;

import kickstarter.entities.ProjectComments;
import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.pages.modelContent.ApplyTransactionModel;
import kickstarter.pages.modelContent.CategoriesModel;
import kickstarter.pages.modelContent.CommentModel;
import kickstarter.pages.modelContent.DetailedProjectModel;
import kickstarter.pages.modelContent.DonateModel;
import kickstarter.pages.modelContent.InvestModel;
import kickstarter.pages.modelContent.PageModel;
import kickstarter.pages.modelContent.ProjectsModel;
import kickstarter.pages.modelContent.ResultOfBankModel;
import kickstarter.pages.modelContent.TheEndModel;
import kickstarter.pages.modelContent.WrongModel;
import kickstarter.pages.viewContent.ApplyTransaction;
import kickstarter.pages.viewContent.Categories;
import kickstarter.pages.viewContent.Comment;
import kickstarter.pages.viewContent.DetailedProject;
import kickstarter.pages.viewContent.Donate;
import kickstarter.pages.viewContent.Invest;
import kickstarter.pages.viewContent.PageView;
import kickstarter.pages.viewContent.Projects;
import kickstarter.pages.viewContent.ResultOfBankOperation;
import kickstarter.pages.viewContent.TheEnd;
import kickstarter.pages.viewContent.WrongChoice;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.Repository;
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
		controller.setPage(0);
		PageModel pageModel = new CategoriesModel(model);
		model.addPageModel(pageModel);

		pageModel = new ProjectsModel(model);
		model.addPageModel(pageModel);

		pageModel = new DetailedProjectModel(model);
		model.addPageModel(pageModel);

		pageModel = new WrongModel(model);
		model.addPageModel(pageModel);

		pageModel = new TheEndModel(model);
		model.addPageModel(pageModel);

		pageModel = new CommentModel(repository, model);
		model.addPageModel(pageModel);

		pageModel = new InvestModel(repository, model);
		model.addPageModel(pageModel);

		pageModel = new DonateModel(bank, repository, model);
		model.addPageModel(pageModel);

		pageModel = new ResultOfBankModel(model);
		model.addPageModel(pageModel);

		pageModel = new ApplyTransactionModel(bank, repository, model);
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
		String message = null;

		while (true) {
			controller.showPage();
			message = ui.inputString();
			controller.update(message);
		}
	}
}
