package com.kickstarter.app;



import com.kickstarter.dao.CategoryDao;
import com.kickstarter.dao.ProjectDao;
import com.kickstarter.dao.QuestionDao;
import com.kickstarter.dao.QuoteDao;
import com.kickstarter.manager.PaymentSystem;
import com.kickstarter.manager.QuestionSystem;
import com.kickstarter.model.Category;
import com.kickstarter.model.Project;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class KRun {

	QuoteDao quoteDao = new QuoteDao();
	QuestionDao questionDao = new QuestionDao();
	QuestionSystem questionSystem = new QuestionSystem();
	PaymentSystem ps = new PaymentSystem();
	ConsolePrintView consolePrint = new ConsolePrintView();
	CategoryDao categoryDao = new CategoryDao();
	ProjectDao projectDao = new ProjectDao();
	final int EXIT_SIGN = 0;

	public void categorySelector() {
		consolePrint.qoutePrint(quoteDao.get());
		try {
			consolePrint.allCategoriesView(categoryDao.getAllCategories());
			consolePrint.categorySelectionInform();
			int selectedCategoryNumber = UserConsoleInputReader.readInput();
			if (selectedCategoryNumber == EXIT_SIGN) {
				consolePrint.programExitInform();
			} else {
				int selectedCategoryId = categoryDao.getAllCategories().get(selectedCategoryNumber - 1).getId();
				String categoryTitle = categoryDao.getCategorieByNumber(selectedCategoryId).getTitle();
				Category selectedCategory = categoryDao.getCategorieByNumber(selectedCategoryId);
				consolePrint.selectedCategoryInformer(categoryTitle);
				consolePrint.categorysProjectsView(projectDao.getAll(categoryTitle));
				projectSelector(selectedCategory);
			}
		} catch (Exception e) {
			System.out.println("There is no such category available");
			categorySelector();
		}
	
	}

	public void projectSelector(Category selectedCategory) {
		try {
			consolePrint.projectSelectionInform();
			consolePrint.exitInformer();
			consolePrint.viewSelectedCategoryProjects(projectDao.getAll(selectedCategory.getTitle()));
			while (true) {
				int userSelectedProjectNumber = UserConsoleInputReader.readInput();
				if (userSelectedProjectNumber == EXIT_SIGN) {
					categorySelector();
				} else {
					int projectId = projectDao.getAll(selectedCategory.getTitle()).get(userSelectedProjectNumber -1).getId();
					Project p = projectDao.getOne(projectId);
					String projectTitle = projectDao.getOne(projectId).getTitle();
					consolePrint.choosenProjectTitleInform(projectTitle);
					consolePrint.selectetProjectView(projectDao.getOne(projectId));
					consolePrint.selectetProjectQuestionsView(questionDao.getProjectQuestions(projectTitle));
					consolePrint.posobilitiesInfirm();
					int selectedAction = UserConsoleInputReader.readInput();
					int payChoise = 200;
					int quastionChoice = 300;
					if (selectedAction == payChoise) {
						consolePrint.paymentPosobilitiesInfo();
						ps.makePayment(p);
						consolePrint.selectetProjectView(projectDao.getOne(projectId));
						projectSelector(selectedCategory);
					}
					if (selectedAction == quastionChoice) {
						questionSystem.provideNewQuestion(p);
						consolePrint.selectetProjectView(p);
						consolePrint.selectetProjectQuestionsView(questionDao.getProjectQuestions(projectTitle));
						projectSelector(selectedCategory);
					} else {
						projectSelector(selectedCategory);

					}

				}

			}
		} catch (Exception e) {
			System.out.println("No such project available");
			projectSelector(selectedCategory);

		}

	}
}