package ua.dborisenko.kickstarter;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Error;
import ua.dborisenko.kickstarter.view.View;
import ua.dborisenko.kickstarter.view.CategoriesView;
import ua.dborisenko.kickstarter.view.CategoryView;
import ua.dborisenko.kickstarter.view.ErrorView;
import ua.dborisenko.kickstarter.view.ProjectView;

public class Kickstarter {

    private static enum MenuPosition {
        CATEGORIES, CATEGORY, PROJECT, EXIT
    }

    private MenuPosition menuPosition = MenuPosition.CATEGORIES;
    private Category currentCategory;
    private CategoryDao categoryDao;
    private QuoteDao quoteDao;
    private View currentView;

    public Kickstarter(String[] args) {
        DaoInitializer daoInitializer = new DaoInitializer();
        quoteDao = daoInitializer.initQuoteDao(args);
        categoryDao = daoInitializer.initCategoryDao(args);
        currentView = new CategoriesView(categoryDao.getAll(), quoteDao.getRandomQuote());
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
            } else {
                showError(501, "Not Implemented", "Unknown view type.");
            }
        }
        System.out.println("Have a nice day!");
    }

    void handleViewProjectResult(String inputData) {
        if (inputData.equals("0")) {
            currentView = new CategoryView(currentCategory);
            menuPosition = MenuPosition.CATEGORY;
        }
    }

    void handleViewCategoryResult(String inputData) {
        if (inputData.equals("0")) {
            currentCategory = null;
            currentView = new CategoriesView(categoryDao.getAll(), quoteDao.getRandomQuote());
            menuPosition = MenuPosition.CATEGORIES;
        } else {
            try {
                int projectNumber = Integer.valueOf(inputData) - 1;
                currentView = new ProjectView(currentCategory.getProjectByListNumber(projectNumber),
                        currentCategory.getName());
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
