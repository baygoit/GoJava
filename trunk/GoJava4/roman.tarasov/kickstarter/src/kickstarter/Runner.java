package kickstarter;

import java.sql.SQLException;

import kickstarter.dao.DAO;
import kickstarter.dao.databaseServices.DBcategoryService;
import kickstarter.dao.databaseServices.DBcommentService;
import kickstarter.dao.databaseServices.DBprojectService;
import kickstarter.dao.databaseServices.DBquoteService;
import kickstarter.dao.databaseServices.DatabaseService;
import kickstarter.dao.databaseServices.DatabaseSettings;
import kickstarter.dao.databaseServices.iDatabaseService;
import kickstarter.dao.defaultServices.DefaultCategoryService;
import kickstarter.dao.defaultServices.DefaultCommentService;
import kickstarter.dao.defaultServices.DefaultProjectService;
import kickstarter.dao.defaultServices.DefaultQuoteService;
import kickstarter.dao.interfaces.iDAO;
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
import kickstarter.pages.modelContent.DAOmenuModel;
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
import kickstarter.pages.viewContent.DAOmenu;
import kickstarter.pages.viewContent.ResultOfBankOperation;
import kickstarter.pages.viewContent.TheEnd;
import kickstarter.pages.viewContent.WrongChoice;
import kickstarter.payment.Bank;
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
		Bank bank = new Bank();
		Model model = new Model();
		View view = new View(ui);

		iDatabaseService databaseService = new DatabaseService();
		iDAO iDefaultDAO = setDefaultServices(new DAO());
		iDAO iDatabaseDAO = setDatabaseServices(new DAO(), databaseService);
/*
		try {
			databaseService.createConnection(new DatabaseSettings(
					"jdbc:postgresql://localhost:5432/kickstarter", "postgres",
					"root"));
			//databaseService.createDefaultDatabase(iDefaultDAO, iDatabaseDAO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		Controller controller = new Controller();
		iController icontroller = controller;
		controller.setDatabaseService(databaseService);
		modelInit(model, bank, icontroller);
		viewInit(view, bank, icontroller);
		controllerInit(controller, view, model, iDefaultDAO, iDatabaseDAO);

		kickstarter = Kickstarter.getInstance();
		kickstarter.setController(controller);
		kickstarter.setView(view);
		kickstarter.setModel(model);
		kickstarter.setDatabaseService(databaseService);
		kickstarter.setUI(ui);

	}

	private iDAO setDatabaseServices(iDAO idao, iDatabaseService databaseService) {
		idao.setCategoryService(new DBcategoryService(databaseService));
		idao.setProjectService(new DBprojectService(databaseService));
		idao.setCommentService(new DBcommentService(databaseService));
		idao.setQuoteService(new DBquoteService(databaseService));
		return idao;
	}

	private iDAO setDefaultServices(iDAO idao) {
		idao.setCategoryService(new DefaultCategoryService());
		idao.setProjectService(new DefaultProjectService());
		idao.setCommentService(new DefaultCommentService());
		idao.setQuoteService(new DefaultQuoteService());
		return idao;
	}

	private void controllerInit(Controller controller, View view, Model model,
			iDAO iDefaultDAO, iDAO iDatabaseDAO) {

		controller.setInterfaces(view, model);
		controller.setView(view);
		controller.setModel(model);
		controller.setDaoInterfaces(iDefaultDAO, iDatabaseDAO);
		controller.setDefaultDAO();
		controller.setPage(IndexOfPage.CATEGORIES.ordinal());
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

		pageModel = new DAOmenuModel(icontroller);
		model.addPageModel(pageModel);

	}

	private void viewInit(View view, Bank bank, iController icontroller) {

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

		pageView = new DAOmenu(icontroller);
		view.addPageView(pageView);
	}

}
