package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.view.MainPageView;

import java.util.List;

import static java.lang.Integer.parseInt;

public class MainPageController extends AbstractController {
    private List<Category> model;
    private MainPageView view;
    private CategoryController categoryController;

    public void setView(MainPageView view) {
        this.view = view;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    private int getCategoryId(String input) {
        return model.get(parseInt(input) - 1).getId();
    }

    @Override
    public void updateModel() {
        model = dataProvider.getCategories();
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
        view.render(model, dataProvider.getWelcomeMessage());
    }

    @Override
    protected void doValidControl(String input) {
        categoryController.setCategoryId(getCategoryId(input));
        setNextController(categoryController);
    }
}
