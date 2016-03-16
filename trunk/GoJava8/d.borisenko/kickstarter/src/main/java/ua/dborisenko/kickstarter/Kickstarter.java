package ua.dborisenko.kickstarter;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Error;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.view.CategoriesView;
import ua.dborisenko.kickstarter.view.CategoryView;
import ua.dborisenko.kickstarter.view.ErrorView;
import ua.dborisenko.kickstarter.view.InvestmentView;
import ua.dborisenko.kickstarter.view.ProjectView;
import ua.dborisenko.kickstarter.view.View;

public class Kickstarter {
    private static enum MenuPosition {
        CATEGORIES, CATEGORY, PROJECT, INVESTMENT, EXIT
    }

    private MenuPosition menuPosition = MenuPosition.CATEGORIES;
    private Category currentCategory;
    private Project currentProject;
    private CategoryDao categoryDao;
    private QuoteDao quoteDao;
    private View currentView;

    public void run() {
        DaoInitializer daoInitializer = new DaoInitializer();
        quoteDao = daoInitializer.initQuoteDao();
        categoryDao = daoInitializer.initCategoryDao();
        currentView = new CategoriesView(categoryDao.getAllCategories(), quoteDao.getRandomQuote());
        showMainMenu();
    }

    void showError(int errorCode, String errorName, String errorDescription) {
        Error error = new Error(errorCode, errorName, errorDescription);
        ErrorView viewError = new ErrorView(error);
        viewError.show();
        viewError.getInput();
    }

    void showMainMenu() {
        while (menuPosition != MenuPosition.EXIT) {
            currentView.show();
            String inputData = currentView.getInput();
            if (MenuPosition.CATEGORIES == menuPosition) {
                handleViewCategoriesResult(inputData);
            } else if (MenuPosition.CATEGORY == menuPosition) {
                handleViewCategoryResult(inputData);
            } else if (MenuPosition.PROJECT == menuPosition) {
                handleViewProjectResult(inputData);
            } else if (MenuPosition.INVESTMENT == menuPosition) {
                handleViewInvestmentResult(inputData);
            } else {
                showError(501, "Not Implemented", "Unknown view type.");
            }
        }
        currentView.showHint("Goodbye! Thanks for all the fish.");
    }

    private void handleViewInvestmentResult(String inputData) {
        Investment investment = new Investment();
        investment.setCardHolderName(inputData);
        currentView.showHint("Enter your card number: ");
        investment.setCardNumber(currentView.getInput());
        currentView.showHint("Enter your investment amount: ");
        try {
            investment.setAmount(Integer.valueOf(currentView.getInput()));
        } catch (NumberFormatException e) {
            showError(400, "Bad Request", "Wrong input data.");
        }
        currentProject.addInvestment(investment);
        currentView = new ProjectView(currentProject, currentCategory.getName());
        menuPosition = MenuPosition.PROJECT;
    }

    void handleViewProjectResult(String inputData) {
        if (inputData.equals("0")) {
            currentView = new CategoryView(currentCategory);
            menuPosition = MenuPosition.CATEGORY;
        } else if (inputData.equals("1")) {
            currentView = new InvestmentView(currentProject);
            menuPosition = MenuPosition.INVESTMENT;
        } else if (inputData.equals("2")) {
            currentView.showHint("Enter your question");
            Question question = new Question();
            question.setRequest(currentView.getInput());
            currentProject.addQuestion(question);
            currentView = new ProjectView(currentProject, currentCategory.getName());
        }
    }

    void handleViewCategoryResult(String inputData) {
        if (inputData.equals("0")) {
            currentCategory = null;
            currentView = new CategoriesView(categoryDao.getAllCategories(), quoteDao.getRandomQuote());
            menuPosition = MenuPosition.CATEGORIES;
        } else {
            try {
                int projectNumber = Integer.valueOf(inputData) - 1;
                currentProject = currentCategory.getProjectByListNumber(projectNumber);
                currentView = new ProjectView(currentProject, currentCategory.getName());
                menuPosition = MenuPosition.PROJECT;
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }

    void handleViewCategoriesResult(String inputData) {
        if (inputData.equals("0")) {
            menuPosition = MenuPosition.EXIT;
        } else {
            try {
                int categoryNumber = Integer.valueOf(inputData) - 1;
                currentCategory = categoryDao.getByListNumber(categoryNumber);
                currentView = new CategoryView(currentCategory);
                menuPosition = MenuPosition.CATEGORY;
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }
}
