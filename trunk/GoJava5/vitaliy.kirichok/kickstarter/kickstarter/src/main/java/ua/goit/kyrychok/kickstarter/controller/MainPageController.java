package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.view.MainPageView;

import java.util.List;

import static java.lang.Integer.parseInt;

public class MainPageController extends AbstractController {
    private List<Category> model;
    private MainPageView view;
    private CategoryController categoryController;
    private CategoryDao categoryDao;

    public MainPageController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void setView(MainPageView view) {
        this.view = view;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public void setModel(List<Category> model) {
        this.model = model;
    }

    private int getCategoryId(String input) {
        return model.get(parseInt(input) - 1).getId();
    }

    @Override
    public void updateModel() {
        model = categoryDao.fetch();
    }

    @Override
    protected boolean isValid(String input) {
        try {
            int inputValue = parseInt(input);
            return !(inputValue < 1 || inputValue > model.size());
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void renderModel() {
        view.render(model, categoryDao.getWelcomeMessage());
    }

    @Override
    protected void doValidControl(String input) {
        categoryController.setCategoryId(getCategoryId(input));
        setNextController(categoryController);
    }

    @Override
    protected void showError(String input) {
    }
}
