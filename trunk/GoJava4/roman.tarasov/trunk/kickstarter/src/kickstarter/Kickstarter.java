package kickstarter;

import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.mvc.interfaces.iController;
import kickstarter.pages.modelContent.ApplyTransactionModel;
import kickstarter.pages.modelContent.CategoriesModel;
import kickstarter.pages.modelContent.CommentModel;
import kickstarter.pages.modelContent.DetailedProjectModel;
import kickstarter.pages.modelContent.DonateModel;
import kickstarter.pages.modelContent.RepositoryMenuModel;
import kickstarter.pages.modelContent.InvestModel;
import kickstarter.pages.modelContent.PageModel;
import kickstarter.pages.modelContent.ProjectsModel;
import kickstarter.pages.modelContent.ResultOfBankOperationModel;
import kickstarter.pages.modelContent.TheEndModel;
import kickstarter.pages.modelContent.WrongChoiceModel;
import kickstarter.pages.viewContent.ApplyTransaction;
import kickstarter.pages.viewContent.Categories;
import kickstarter.pages.viewContent.Comment;
import kickstarter.pages.viewContent.DetailedProject;
import kickstarter.pages.viewContent.Donate;
import kickstarter.pages.viewContent.RepositoryMenu;
import kickstarter.pages.viewContent.Invest;
import kickstarter.pages.viewContent.PageView;
import kickstarter.pages.viewContent.Projects;
import kickstarter.pages.viewContent.ResultOfBankOperation;
import kickstarter.pages.viewContent.TheEnd;
import kickstarter.pages.viewContent.WrongChoice;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.FileSystemRepository;
import kickstarter.repository.facade.Repository;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.iUserInterface;

public class Kickstarter {

	private View view;
	private Model model;
	public Controller controller;
	public iController icontroller;
	private iUserInterface ui;
	private FileSystemRepository fileSystemRepository;
	private Repository inMemoryRepository;
	private Bank bank;

	public Kickstarter() {
	}

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.init();
		kickstarter.run();
	}

	public void init() {
		inMemoryRepository = new Repository();

		fileSystemRepository = new FileSystemRepository();

		bank = new Bank();
		model = new Model();
		ui = new ConsoleUI();
		view = new View(ui);
		controller = new Controller(view, model, fileSystemRepository,
				inMemoryRepository);
		icontroller = controller;
		viewInit();
		modelInit();
		controllerInit();
	}

	private void controllerInit() {
		controller.setPage(0);
		//controller.setRepository(fileSystemRepository);
		controller.setRepository(inMemoryRepository);
		controller.setFileNameOfRepository("repository");
		controller.setModel(model);
	}

	private void modelInit() {

		PageModel pageModel = new CategoriesModel();
		model.addPageModel(pageModel);

		pageModel = new ProjectsModel();
		model.addPageModel(pageModel);

		pageModel = new DetailedProjectModel();
		model.addPageModel(pageModel);

		pageModel = new WrongChoiceModel();
		model.addPageModel(pageModel);

		pageModel = new TheEndModel();
		model.addPageModel(pageModel);

		pageModel = new CommentModel();
		model.addPageModel(pageModel);

		pageModel = new InvestModel();
		model.addPageModel(pageModel);

		pageModel = new DonateModel(bank);
		model.addPageModel(pageModel);

		pageModel = new ResultOfBankOperationModel();
		model.addPageModel(pageModel);

		pageModel = new ApplyTransactionModel(bank);
		model.addPageModel(pageModel);

		pageModel = new RepositoryMenuModel(inMemoryRepository,
				fileSystemRepository, icontroller);
		model.addPageModel(pageModel);

	}

	private void viewInit() {

		PageView pageView = new Categories();
		view.addPageView(pageView);

		pageView = new Projects();
		view.addPageView(pageView);

		pageView = new DetailedProject();
		view.addPageView(pageView);

		pageView = new WrongChoice();
		view.addPageView(pageView);

		pageView = new TheEnd();
		view.addPageView(pageView);

		pageView = new Comment();
		view.addPageView(pageView);

		pageView = new Invest();
		view.addPageView(pageView);

		pageView = new Donate(bank);
		view.addPageView(pageView);

		pageView = new ResultOfBankOperation();
		view.addPageView(pageView);

		pageView = new ApplyTransaction();
		view.addPageView(pageView);

		pageView = new RepositoryMenu();
		view.addPageView(pageView);
	}

	public void testUI(iUserInterface ui) {
		this.ui = ui;
		view.setUserInterface(ui);
	}

	private void run() {
		String message = null;

		while (true) {
			controller.showPage();
			message = ui.inputString();
			controller.updateStateOfModel(message);

		}
	}
}
