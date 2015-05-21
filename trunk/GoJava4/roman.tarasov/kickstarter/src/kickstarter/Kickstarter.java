package kickstarter;

import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.mvc.interfaces.iModel;
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
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.QuotesRepository;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.iUserInterface;

public class Kickstarter {

	QuotesRepository quotes;
	CategoriesRepository categories;
	ProjectRepository projects;

	PageModel pageModel;
	View view;
	public Controller controller;
	iUserInterface ui;
	CommentsRepository allComments;
	iModel imodel;

	public Kickstarter() {
		allComments = new CommentsRepository();
		quotes = new QuotesRepository();
		projects = new ProjectRepository();

		categories = new CategoriesRepository();
		ui = new ConsoleUI();

		Model model = new Model();

		view = new View(model, ui);
		controller = new Controller(view, model);
		
		PageView pageView = new Categories(categories, quotes, model);
		pageView.pageId = 0;
		controller.setPage(0);

		pageModel = new CategoriesM(model);
		controller.add(pageView, pageModel);

		pageView = new Projects(projects, model);
		pageModel = new ProjectsM(model);
		controller.add(pageView, pageModel);

		pageView = new DetailedProject(allComments, projects,model);
		pageModel = new DetailedM(model);
		controller.add(pageView, pageModel);

		pageView = new WrongChoice();
		pageModel = new WrongM(model);
		controller.add(pageView, pageModel);

		pageView = new TheEnd();
		pageModel = new TheEndM(model);
		controller.add(pageView, pageModel);

		pageView = new Comment(allComments, projects,model);
		pageModel = new CommentM(allComments, projects, model);
		controller.add(pageView, pageModel);

		pageView = new Invest(projects,model);
		pageModel = new InvestM(projects,model);
		controller.add(pageView, pageModel);

		Bank bank = new Bank();
		pageView = new Donate(bank, projects,model);
		pageModel = new DonateM(bank, projects, model);
		controller.add(pageView, pageModel);

		pageView = new ResultOfBankOperation(model);
		pageModel = new ResultOfBankM(model);
		controller.add(pageView, pageModel);

		pageView = new ApplyTransaction(bank, projects,model);
		pageModel = new ApplyM(bank, projects,model);
		controller.add(pageView, pageModel);
	}

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.run();
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
