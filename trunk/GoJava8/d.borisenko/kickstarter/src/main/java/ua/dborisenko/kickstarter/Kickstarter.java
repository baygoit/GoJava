package ua.dborisenko.kickstarter;

import java.util.List;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Error;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;
import ua.dborisenko.kickstarter.view.CategoriesView;
import ua.dborisenko.kickstarter.view.CategoryView;
import ua.dborisenko.kickstarter.view.ErrorView;
import ua.dborisenko.kickstarter.view.ProjectView;
import ua.dborisenko.kickstarter.view.RewardsView;
import ua.dborisenko.kickstarter.view.View;

public class Kickstarter {
    private static final String MENU_ACTION_RETURN = "0";
    private static final String MENU_ACTION_INVEST = "1";
    private static final String MENU_ACTION_QUESTION = "2";
    private static final String MENU_ACTION_CUSTOM_AMOUNT = "0";

    private static enum MenuPosition {
        CATEGORIES, CATEGORY, PROJECT, REWARDS, EXIT
    }

    private MenuPosition menuPosition;
    private List<String> categoryNamesList;
    private Category currentCategory;
    private Project currentProject;
    private CategoryDao categoryDao;
    private QuoteDao quoteDao;
    private View currentView;

    public void run() {
        DaoInitializer daoInitializer = new DaoInitializer();
        quoteDao = daoInitializer.initQuoteDao();
        categoryDao = daoInitializer.initCategoryDao();
        prepareMenuCategories();
        showMenu();
    }

    void showError(int errorCode, String errorName, String errorDescription) {
        Error error = new Error(errorCode, errorName, errorDescription);
        ErrorView viewError = new ErrorView(error);
        viewError.show();
        viewError.getInput();
    }

    void showMenu() {
        while (menuPosition != MenuPosition.EXIT) {
            currentView.show();
            String inputData = currentView.getInput();
            if (MenuPosition.CATEGORIES == menuPosition) {
                handleViewCategoriesResult(inputData);
            } else if (MenuPosition.CATEGORY == menuPosition) {
                handleViewCategoryResult(inputData);
            } else if (MenuPosition.PROJECT == menuPosition) {
                handleViewProjectResult(inputData);
            } else if (MenuPosition.REWARDS == menuPosition) {
                handleViewRewardsResult(inputData);
            } else {
                showError(501, "Not Implemented", "Unknown view type.");
            }
        }
        currentView.showHint("Goodbye! Thanks for all the fish.");
    }

    void prepareMenuCategories() {
        menuPosition = MenuPosition.CATEGORIES;
        categoryNamesList = categoryDao.getCategoryNames();
        currentView = new CategoriesView(categoryNamesList, quoteDao.getRandomQuote());
    }

    void prepareMenuCategory() {
        menuPosition = MenuPosition.CATEGORY;
        currentView = new CategoryView(currentCategory);
    }

    void prepareMenuProject() {
        menuPosition = MenuPosition.PROJECT;
        categoryDao.getQuestions(currentProject);
        currentView = new ProjectView(currentProject, currentCategory.getName());
    }

    void prepareMenuRewards() {
        menuPosition = MenuPosition.REWARDS;
        categoryDao.getRewards(currentProject);
        currentView = new RewardsView(currentProject);
    }

    void handleViewRewardsResult(String inputData) {
        Investment investment = new Investment();
        try {
            if (MENU_ACTION_CUSTOM_AMOUNT.equals(inputData)) {
                currentView.showHint("Enter the investment amount:");
                investment.setAmount(Integer.valueOf(currentView.getInput()));
            } else {
                int rewardIndex = Integer.valueOf(inputData) - 1;
                Reward reward = currentProject.getRewardByIndex(rewardIndex);
                investment.setAmount(reward.getAmount());
            }
            currentView.showHint("Enter your name:");
            investment.setCardHolderName(currentView.getInput());
            currentView.showHint("Enter your card number: ");
            investment.setCardNumber(currentView.getInput());
            categoryDao.addInvestment(currentProject, investment);
            prepareMenuProject();
        } catch (NumberFormatException e) {
            showError(400, "Bad Request", "Wrong input data.");
        } catch (IndexOutOfBoundsException e) {
            showError(404, "Not Found", "The requested element isn`t found.");
        }
    }

    void handleViewProjectResult(String inputData) {
        if (MENU_ACTION_RETURN.equals(inputData)) {
            prepareMenuCategory();
        } else if (MENU_ACTION_INVEST.equals(inputData)) {
            prepareMenuRewards();
        } else if (MENU_ACTION_QUESTION.equals(inputData)) {
            currentView.showHint("Enter your question");
            Question question = new Question();
            question.setRequest(currentView.getInput());
            categoryDao.addQuestion(currentProject, question);
            currentView = new ProjectView(currentProject, currentCategory.getName());
        }
    }

    void handleViewCategoryResult(String inputData) {
        if (MENU_ACTION_RETURN.equals(inputData)) {
            prepareMenuCategories();
        } else {
            try {
                int projectIndex = Integer.valueOf(inputData) - 1;
                currentProject = currentCategory.getProjectByIndex(projectIndex);
                prepareMenuProject();
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }

    void handleViewCategoriesResult(String inputData) {
        if (MENU_ACTION_RETURN.equals(inputData)) {
            menuPosition = MenuPosition.EXIT;
        } else {
            try {
                int categoryIndex = Integer.valueOf(inputData) - 1;
                currentCategory = categoryDao.getByName(categoryNamesList.get(categoryIndex));
                prepareMenuCategory();
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }
}
