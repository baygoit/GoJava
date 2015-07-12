package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

public class ProjectController {
    private ProjectModel model;
    private ProjectView view;

    public ProjectController(ProjectModel model, ProjectView view) {
        this.model = model;
        this.view = view;
    }

    public boolean update(int categoryIndex, int projectIndex) {
        try {
            model.update(categoryIndex - 1, projectIndex - 1);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        view.render(model);
        return true;
    }
}
