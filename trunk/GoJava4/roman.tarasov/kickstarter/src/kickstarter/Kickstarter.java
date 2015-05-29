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
import kickstarter.repository.facade.FileRepositoryDriver;
import kickstarter.repository.facade.MemoryRepository;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.ui.ConsoleUI;
import kickstarter.ui.iUserInterface;

public class Kickstarter {

	private iUserInterface ui;
	private View view;

	private Model model;
	public Controller controller;
	public iController icontroller;

	public FileRepositoryDriver fileRepositoryDriver;
	private MemoryRepository inMemoryRepository;
	private Bank bank;
	private MemoryRepository memoryRepository;

	public void testUI(iUserInterface ui) {
		this.ui = ui;
		view.setUserInterface(ui);
	}

	void run() {
		String message = null;

		while (true) {
			controller.showPage();
			message = ui.inputString();
			controller.updateStateOfModel(message);
		}
	}

	void setBank(Bank setBank) {
		this.bank = setBank;
	}

	void setController(Controller setController) {
		this.controller = setController;
	}

	void setView(View setView) {
		this.view = setView;
	}

	void setModel(Model setModel) {
		this.model = setModel;
	}

	public void setFileRepositoryDriver(
			FileRepositoryDriver fileRepositoryDriver) {
		this.fileRepositoryDriver = fileRepositoryDriver;
	}

	public void setMemoryRepository(MemoryRepository memoryRepository) {
		this.memoryRepository = memoryRepository;
	}

	public void setUI(iUserInterface ui) {
		this.ui = ui;
	}
}
