package kickstarter;

import kickstarter.mvc.Controller;
import kickstarter.mvc.Model;
import kickstarter.mvc.View;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.interfaces.iController;
import kickstarter.pages.modelContent.ApplyTransactionModel;
import kickstarter.pages.modelContent.CategoriesModel;
import kickstarter.pages.modelContent.CommentModel;
import kickstarter.pages.modelContent.DetailedProjectModel;
import kickstarter.pages.modelContent.DonateModel;
import kickstarter.pages.modelContent.InvestModel;
import kickstarter.pages.modelContent.PageModel;
import kickstarter.pages.modelContent.ProjectsModel;
import kickstarter.pages.modelContent.RepositoryMenuModel;
import kickstarter.pages.modelContent.ResultOfBankOperationModel;
import kickstarter.pages.modelContent.TheEndModel;
import kickstarter.pages.modelContent.WrongChoiceModel;
import kickstarter.pages.viewContent.ApplyTransaction;
import kickstarter.pages.viewContent.Categories;
import kickstarter.pages.viewContent.Comment;
import kickstarter.pages.viewContent.DetailedProject;
import kickstarter.pages.viewContent.Donate;
import kickstarter.pages.viewContent.Invest;
import kickstarter.pages.viewContent.PageView;
import kickstarter.pages.viewContent.Projects;
import kickstarter.pages.viewContent.RepositoryMenu;
import kickstarter.pages.viewContent.ResultOfBankOperation;
import kickstarter.pages.viewContent.TheEnd;
import kickstarter.pages.viewContent.WrongChoice;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.FileRepositoryDriver;
import kickstarter.repository.facade.MemoryRepository;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.iUserInterface;

public class Runner {
	public Kickstarter kickstarter;

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.init();
		runner.run();
	}

	public void run() {
		kickstarter.run();
	}

	public void init() {
		iUserInterface ui = new ConsoleUI();
		MemoryRepository memoryRepository = new MemoryRepository();
		FileRepositoryDriver fileRepositoryDriver = new FileRepositoryDriver();
		Bank bank = new Bank();
		Model model = new Model();
		View view = new View(ui);

		createFileSystemRepository(memoryRepository);
		Controller controller = new Controller();
		iController icontroller = controller;
		modelInit(model, bank, icontroller);
		viewInit(view, bank);
		controllerInit(controller, view, model, fileRepositoryDriver,
				memoryRepository);

		kickstarter = Kickstarter.getInstance();
		kickstarter.setController(controller);
		kickstarter.setView(view);
		kickstarter.setModel(model);
		kickstarter.setUI(ui);
	}

	private void createFileSystemRepository(MemoryRepository inMemoryRepository) {
		try {
			inMemoryRepository.createFileSystemRepository();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void controllerInit(Controller controller, View view, Model model,
			FileRepositoryDriver fileRepositoryDriver,
			MemoryRepository defaultRepository) {

		controller.setInterfaces(view, model);
		controller.setRepositories(fileRepositoryDriver, defaultRepository);
		controller.initView(view);
		controller.initModel(model);
		controller.setPage(IndexOfPage.CATEGORIES.ordinal());
		controller.setInMemoryRepository();
		controller.setFileNameOfRepository("repository");

	}

	private void modelInit(Model model, Bank bank, iController icontroller) {

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

		pageModel = new RepositoryMenuModel(icontroller);
		model.addPageModel(pageModel);

	}

	private void viewInit(View view, Bank bank) {

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

		pageView = new Donate();
		view.addPageView(pageView);

		pageView = new ResultOfBankOperation();
		view.addPageView(pageView);

		pageView = new ApplyTransaction();
		view.addPageView(pageView);

		pageView = new RepositoryMenu();
		view.addPageView(pageView);
	}

}
