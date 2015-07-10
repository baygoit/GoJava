package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.common.Input;
import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.models.MainPageModel;
import ua.goit.kyrychok.views.MainPageView;

public class MainPageController {
    public static final int DEFAULT_POSITION = 0;
    private MainPageModel model;
    private MainPageView view;
    private Input input;
    private CategoryController categoryController;

    public MainPageController(DataProvider dataProvider, Input input, Output output) {
        model = new MainPageModel(dataProvider);
        view = new MainPageView(output);
        this.input = input;
        categoryController = new CategoryController(dataProvider, input, output);
    }

    private boolean validInput(int input, int maxPosition) {
        return (input >= DEFAULT_POSITION && input <= maxPosition);
    }

    public void run() {
        model.load();
        int maxSize = model.getCategories().size();
        int inputData = DEFAULT_POSITION;
        do {
            view.show(model);
            inputData = input.getNext();
            if (validInput(inputData, maxSize) && inputData != DEFAULT_POSITION) {
                categoryController.run(inputData);
            }
        } while (inputData != DEFAULT_POSITION);
    }

}
