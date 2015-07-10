package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.common.Input;
import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.models.CategoryModel;
import ua.goit.kyrychok.views.CategoryView;

public class CategoryController {
    public static final int DEFAULT_POSITION = 0;
    private CategoryModel model;
    private CategoryView view;
    private Input input;
    private ProjectController projectController;

    public CategoryController(DataProvider dataProvider, Input input, Output output) {
        model = new CategoryModel(dataProvider);
        view = new CategoryView(output);
        this.input = input;
        projectController = new ProjectController(dataProvider, input, output);
    }

    private boolean validInput(int input, int maxPosition) {
        return (input >= DEFAULT_POSITION && input <= maxPosition);
    }

    public void run(int index) {
        model.load(index - 1);
        int maxSize = model.getProjects().size();
        int inputData = index;
        while (inputData != DEFAULT_POSITION) {
            view.show(model);
            inputData = input.getNext();
            if (validInput(inputData, maxSize) && inputData != DEFAULT_POSITION) {
                projectController.run(index, inputData);
            }
        }
    }
}
