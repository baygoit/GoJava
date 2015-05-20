package kickstarter;

import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.mvc.iModel;
import kickstarter.pages.ApplyTransaction;
import kickstarter.pages.Categories;
import kickstarter.pages.Comment;
import kickstarter.pages.DetailedProject;
import kickstarter.pages.Donate;
import kickstarter.pages.Invest;
import kickstarter.pages.PageView;
import kickstarter.pages.Projects;
import kickstarter.pages.ResultOfBankOperation;
import kickstarter.pages.TheEnd;
import kickstarter.pages.WrongChoice;
import kickstarter.pages.model.MApply;
import kickstarter.pages.model.MCategories;
import kickstarter.pages.model.MComment;
import kickstarter.pages.model.MDetailed;
import kickstarter.pages.model.MDonate;
import kickstarter.pages.model.MInvest;
import kickstarter.pages.model.MProjects;
import kickstarter.pages.model.MResultOfBank;
import kickstarter.pages.model.MTheEnd;
import kickstarter.pages.model.MWrong;
import kickstarter.pages.model.PageModel;
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

		pageModel = new MCategories(model);
		controller.add(pageView, pageModel);

		pageView = new Projects(projects, model);
		pageModel = new MProjects(model);
		controller.add(pageView, pageModel);

		pageView = new DetailedProject(allComments, projects,model);
		pageModel = new MDetailed(model);
		controller.add(pageView, pageModel);

		pageView = new WrongChoice();
		pageModel = new MWrong(model);
		controller.add(pageView, pageModel);

		pageView = new TheEnd();
		pageModel = new MTheEnd(model);
		controller.add(pageView, pageModel);

		pageView = new Comment(allComments, projects,model);
		pageModel = new MComment(allComments, projects, model);
		controller.add(pageView, pageModel);

		pageView = new Invest(projects,model);
		pageModel = new MInvest(projects,model);
		controller.add(pageView, pageModel);

		Bank bank = new Bank();
		pageView = new Donate(bank, projects,model);
		pageModel = new MDonate(bank, projects, model);
		controller.add(pageView, pageModel);

		pageView = new ResultOfBankOperation(model);
		pageModel = new MResultOfBank(model);
		controller.add(pageView, pageModel);

		pageView = new ApplyTransaction(bank, projects,model);
		pageModel = new MApply(bank, projects,model);
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
