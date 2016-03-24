package ua.dborisenko.kickstarter;

import java.sql.SQLException;
import java.util.List;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;
import ua.dborisenko.kickstarter.view.CategoriesView;
import ua.dborisenko.kickstarter.view.CategoryView;
import ua.dborisenko.kickstarter.view.ProjectView;
import ua.dborisenko.kickstarter.view.RewardsView;

public class Kickstarter {
    private static final String ERR_NOT_FOUND = "The requested element isn't found.";
    private static final String ERR_WRONG_INPUT = "Wrong input data.";
    private static final String ERR_UNKNOWN_POSITION = "Unknown menu position";

    private static enum MenuPosition {
        CATEGORIES, CATEGORY, PROJECT, REWARDS, EXIT
    }

    private MenuPosition menuPosition;
    private List<String> categoryNamesList;
    private Category currentCategory;
    private Project currentProject;
    private CategoryDao categoryDao;
    private QuoteDao quoteDao;
    private CategoriesView categoriesView = new CategoriesView();
    private CategoryView categoryView = new CategoryView();
    private ProjectView projectView = new ProjectView();
    private RewardsView rewardsView = new RewardsView();

    public void run() throws SQLException {
        DaoInitializer daoInitializer = new DaoInitializer();
        quoteDao = daoInitializer.getQuoteDao();
        categoryDao = daoInitializer.getCategoryDao();
        prepareMenuCategories();
        showMenu();
        daoInitializer.closeSqlConnections();
    }

    void showMenu() {
        while (menuPosition != MenuPosition.EXIT) {
            if (MenuPosition.CATEGORIES == menuPosition) {
                handleViewCategoriesResult(categoriesView.getInput());
            } else if (MenuPosition.CATEGORY == menuPosition) {
                handleViewCategoryResult(categoryView.getInput());
            } else if (MenuPosition.PROJECT == menuPosition) {
                handleViewProjectResult(projectView.getInput());
            } else if (MenuPosition.REWARDS == menuPosition) {
                handleViewRewardsResult(rewardsView.getInput());
            } else {
                throw new IllegalStateException(ERR_UNKNOWN_POSITION);
            }
        }
        categoriesView.showMsgGoodbye();
    }

    void prepareMenuCategories() {
        menuPosition = MenuPosition.CATEGORIES;
        categoryNamesList = categoryDao.getCategoryNames();
        categoriesView.showContent(categoryNamesList, quoteDao.getRandomQuote());
    }

    void prepareMenuCategory() {
        menuPosition = MenuPosition.CATEGORY;
        categoryView.showContent(currentCategory);
    }

    void prepareMenuProject() {
        menuPosition = MenuPosition.PROJECT;
        categoryDao.getQuestions(currentProject);
        projectView.showContent(currentProject, currentCategory.getName());
    }

    void prepareMenuRewards() {
        menuPosition = MenuPosition.REWARDS;
        categoryDao.getRewards(currentProject);
        rewardsView.showContent(currentProject);
    }

    void handleViewRewardsResult(String inputData) {
        Investment investment = new Investment();
        try {
            if (RewardsView.INPUT_TO_CUSTOM_AMOUNT.equals(inputData)) {
                rewardsView.showMsgEnterAmount();
                investment.setAmount(Integer.valueOf(rewardsView.getInput()));
            } else {
                int rewardIndex = Integer.valueOf(inputData) - 1;
                Reward reward = currentProject.getRewardByIndex(rewardIndex);
                investment.setAmount(reward.getAmount());
            }
            rewardsView.showMsgEnterName();
            investment.setCardHolderName(rewardsView.getInput());
            rewardsView.showMsgEnterCardNumber();
            investment.setCardNumber(rewardsView.getInput());
            categoryDao.addInvestment(currentProject, investment);
            prepareMenuProject();
        } catch (IndexOutOfBoundsException e) {
            rewardsView.showError(ERR_NOT_FOUND);
            prepareMenuProject();
        } catch (NumberFormatException e) {
            rewardsView.showError(ERR_WRONG_INPUT);
            prepareMenuProject();
        }
    }

    void handleViewProjectResult(String inputData) {
        if (ProjectView.INPUT_TO_RETURN.equals(inputData)) {
            prepareMenuCategory();
        } else if (ProjectView.INPUT_TO_INVEST.equals(inputData)) {
            prepareMenuRewards();
        } else if (ProjectView.INPUT_TO_QUESTION.equals(inputData)) {
            projectView.showMsgEnterQuestion();
            Question question = new Question();
            question.setRequest(projectView.getInput());
            categoryDao.addQuestion(currentProject, question);
            projectView.showContent(currentProject, currentCategory.getName());
        } else {
            projectView.showError(ERR_WRONG_INPUT);
            prepareMenuProject();
        }
    }

    void handleViewCategoryResult(String inputData) {
        if (CategoryView.INPUT_TO_RETURN.equals(inputData)) {
            prepareMenuCategories();
        } else {
            try {
                int projectIndex = Integer.valueOf(inputData) - 1;
                currentProject = currentCategory.getProjectByIndex(projectIndex);
                prepareMenuProject();
            } catch (IndexOutOfBoundsException e) {
                categoryView.showError(ERR_NOT_FOUND);
                prepareMenuCategory();
            } catch (NumberFormatException e) {
                categoryView.showError(ERR_WRONG_INPUT);
                prepareMenuCategory();
            }
        }
    }

    void handleViewCategoriesResult(String inputData) {
        if (CategoriesView.INPUT_TO_EXIT.equals(inputData)) {
            menuPosition = MenuPosition.EXIT;
        } else {
            try {
                int categoryIndex = Integer.valueOf(inputData) - 1;
                currentCategory = categoryDao.getByName(categoryNamesList.get(categoryIndex));
                prepareMenuCategory();
            } catch (IndexOutOfBoundsException e) {
                categoriesView.showError(ERR_NOT_FOUND);
                prepareMenuCategories();
            } catch (NumberFormatException e) {
                categoriesView.showError(ERR_WRONG_INPUT);
                prepareMenuCategories();
            }
        }
    }
}
