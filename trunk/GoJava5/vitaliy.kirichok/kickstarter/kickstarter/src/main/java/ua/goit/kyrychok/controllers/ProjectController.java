package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.models.ProjectModel;
import ua.goit.kyrychok.views.ProjectView;

public class ProjectController {
    public static final int DEFAULT_POSITION = 0;
    private ProjectModel model;
    private ProjectView view;
    private int currentPosition;

    public ProjectController(DataProvider dataProvider, Output output) {
        model = new ProjectModel(dataProvider);
        view = new ProjectView(output);
        currentPosition = DEFAULT_POSITION;
    }

    public void showModel(int categoryIndex, int projectIndex) {
        if (currentPosition == DEFAULT_POSITION) {
            currentPosition = projectIndex;
        }
        model.load(categoryIndex - 1, currentPosition - 1);
        view.show(model);
    }

    public void handle(int categoryIndex, int projectIndex) {
        showModel(categoryIndex, projectIndex);
    }

    public boolean canHandle(int index) {
        return index != DEFAULT_POSITION;
    }

}
