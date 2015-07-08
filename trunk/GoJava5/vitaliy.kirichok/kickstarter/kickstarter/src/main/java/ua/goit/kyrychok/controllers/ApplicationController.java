package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.common.Console;
import ua.goit.kyrychok.domain.Category;
import ua.goit.kyrychok.views.ApplicationView;
import ua.goit.kyrychok.views.CategoryView;

import java.util.List;

public class ApplicationController {
    private List<Category> model;
    private ApplicationView view;
    private Console console = new Console();

    public ApplicationController(List<Category> model, ApplicationView view) {
        this.model = model;
        this.view = view;
    }

    public void showModel(String path) {
        final String location = path.concat("/");
        int result;
        do {
            view.show(location, model);
            result = console.readValidInt("Enter your choice(0 - back): ", model.size());
            if (result > 0) {
                Category category = model.get(result - 1);
                CategoryController categoryController = new CategoryController(category, new CategoryView());
                categoryController.showModel(location);
            }
        } while (result != 0);
    }
}
