package ua.dborisenko.kickstarter;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;

public class Kickstarter {
    private static enum MenuPosition {CATEGORIES, CATEGORY, PROJECT, EXIT};
    private MenuPosition menuPosition = MenuPosition.CATEGORIES;
    private Category currentCategory;
    private Project currentProject;
    private CategoryDao categoryDao = new CategoryDao();
    private QuoteDao quoteDao = new QuoteDao();
    private View currentView;
    
    public void start() {
        categoryDao.fillHardcodedCategories();
        quoteDao.fillAllQuotes();
        currentView = new ViewCategories(categoryDao.getAll(), quoteDao.getRandomQuote());
        showMainMenu();
    }
    
    private void showError(int errorCode, String errorName, String errorDescription) {
        Error error = new Error(errorCode, errorName, errorDescription);
        ViewError viewError = new ViewError(error);
        viewError.generate();
        viewError.getInput();
    }

    public void showMainMenu() {
        while (menuPosition != MenuPosition.EXIT) {
            currentView.generate();
            String inputData = this.currentView.getInput();
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

    private void handleViewProjectResult(String inputData) {
        if (inputData.equals("0")) {
            currentProject = null;
            currentView = new ViewCategory(currentCategory);
            menuPosition = MenuPosition.CATEGORY;
        }
    }

    private void handleViewCategoryResult(String inputData) {
        if (inputData.equals("0")) {
            currentCategory = null;
            currentView = new ViewCategories(categoryDao.getAll(), quoteDao.getRandomQuote());
            menuPosition = MenuPosition.CATEGORIES;
        } else {
            try {
                int projectNumber = Integer.valueOf(inputData) - 1;
                currentProject = currentCategory.getProjectByListNumber(projectNumber);
                currentView = new ViewProject(currentProject, currentCategory.getName());
                menuPosition = MenuPosition.PROJECT;
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }

    private void handleViewCategoriesResult(String inputData) {
        if (inputData.equals("0")) {
            menuPosition = MenuPosition.EXIT;
        } else {
            try {
                int categoryNumber = Integer.valueOf(inputData) - 1;
                currentCategory = categoryDao.getByListNumber(categoryNumber);
                currentView = new ViewCategory(currentCategory);
                menuPosition = MenuPosition.CATEGORY;
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }
}
