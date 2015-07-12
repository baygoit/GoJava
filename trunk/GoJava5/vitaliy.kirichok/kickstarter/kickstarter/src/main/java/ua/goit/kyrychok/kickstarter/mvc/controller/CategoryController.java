package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;
import ua.goit.kyrychok.kickstarter.mvc.view.CategoryView;

public class CategoryController {
    private CategoryModel model;
    private CategoryView view;

    public CategoryController(CategoryModel model, CategoryView view) {
        this.model = model;
        this.view = view;
    }

    public boolean update(int index) {
        try {
            model.update(index - 1);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        view.render(model);
        return true;
    }
}
