package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.models.CategoryModel;
import ua.goit.kyrychok.views.CategoryView;

public class CategoryController {
    public static final int DEFAULT_POSITION = 0;
    private CategoryModel model;
    private CategoryView view;
    private ProjectController projectController;
    private int currentPosition;

    public CategoryController(DataProvider dataProvider, Output output) {
        model = new CategoryModel(dataProvider);
        view = new CategoryView(output);
        projectController = new ProjectController(dataProvider, output);
        currentPosition = DEFAULT_POSITION;
    }

    private void showModel(int input) {
        currentPosition = input;
        model.load(input - 1);
        view.show(model);
    }

    public void handle(int input) {
        if (input == DEFAULT_POSITION && input == currentPosition) {
            return;
        }
        if (false) {
            currentPosition = input;
            //   categoryController.handle(input);
        } else {
            showModel(input);
        }
    }

    public boolean canHandle(int index) {
        return !(index == DEFAULT_POSITION && index == currentPosition);
    }
}
