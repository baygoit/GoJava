package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.model.Categories;
import ua.goit.kyrychok.kickstarter.view.MainPageView;

import static java.lang.Integer.parseInt;

public class MainPageController extends BaseController {
    private Categories model = new Categories();
    private MainPageView view;
    private CategoryController categoryController;

    public void setView(MainPageView view) {
        this.view = view;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public void updateModel() {
        model.setCategories(dataProvider.getCategories());
    }

    private boolean isValid(String input) {
        try {
            int inputValue = parseInt(input);
            return !(inputValue < 1 || inputValue > model.getCategories().size());
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int getCategoryId(String input) {
        return model.getCategories().get(parseInt(input) - 1).getId();
    }

    @Override
    public void showModel() {
        updateModel();
        onShowModel();
        view.render(model, dataProvider.getWelcomeMessage());
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            categoryController.setCategoryId(getCategoryId(input));
            setNextController(categoryController);
        } else {
            setNextController(this);
        }
    }
}
