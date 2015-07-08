package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.common.Console;
import ua.goit.kyrychok.domain.Project;
import ua.goit.kyrychok.views.ProjectView;

public class ProjectController {
    private Project model;
    private ProjectView view;
    private Console console = new Console();

    public ProjectController(Project model, ProjectView view) {
        this.model = model;
        this.view = view;
    }

    public void showModel(String path) {
        final String location = path.concat(model.getName()).concat("/");
        int result;
        do {
            view.show(location, model);
            result = console.readValidInt("Enter your choice(0 - back): ", 0);
        } while (result != 0);
    }
}
