package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.common.Input;
import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.models.ProjectModel;
import ua.goit.kyrychok.views.ProjectView;

public class ProjectController {
    public static final int DEFAULT_POSITION = 0;
    private ProjectModel model;
    private ProjectView view;
    private Input input;

    public ProjectController(DataProvider dataProvider, Input input, Output output) {
        model = new ProjectModel(dataProvider);
        view = new ProjectView(output);
        this.input = input;
    }

    private boolean validInput(int input) {
        return input == DEFAULT_POSITION;
    }

    public void run(int categoryIndex, int projectIndex) {
        model.load(categoryIndex - 1, projectIndex - 1);
        int inputData;
        do {
            view.show(model);
            inputData = input.getNext();
        } while (!validInput(inputData));
    }
}
