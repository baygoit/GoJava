package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.models.MainPageModel;
import ua.goit.kyrychok.views.MainPageView;

public class MainPageController {
    public static final int DEFAULT_POSITION = 0;
    private MainPageModel model;
    private MainPageView view;
    private int currentPosition;
    private CategoryController categoryController;

    public MainPageController(DataProvider dataProvider, Output output) {
        model = new MainPageModel(dataProvider);
        view = new MainPageView(output);
        categoryController = new CategoryController(dataProvider, output);
        currentPosition = -1;
    }

    public boolean canHandle(int index) {
        return !(index == DEFAULT_POSITION && index == currentPosition);
    }

    public void handle(int input) {
        if (input == DEFAULT_POSITION && input == currentPosition) {
            return;
        }
        if (categoryController.canHandle(input)) {
            currentPosition = input;
            categoryController.handle(input);
        } else {
            showModel();
        }
    }

    private void showModel() {
        currentPosition = DEFAULT_POSITION;
        model.load();
        view.show(model);
    }

}
