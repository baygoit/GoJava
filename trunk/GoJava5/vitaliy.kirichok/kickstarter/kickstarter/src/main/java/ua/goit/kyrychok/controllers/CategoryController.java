package ua.goit.kyrychok.controllers;

import ua.goit.kyrychok.common.Console;
import ua.goit.kyrychok.domain.Category;
import ua.goit.kyrychok.domain.Project;
import ua.goit.kyrychok.views.CategoryView;
import ua.goit.kyrychok.views.ProjectView;

public class CategoryController {
    private Category model;
    private CategoryView view;
    private Console console = new Console();

    public CategoryController(Category model, CategoryView view) {
        this.model = model;
        this.view = view;
    }

    public void showModel(String path) {
        final String location = path.concat(model.getName()).concat("/");
        int result;
        do {
            view.show(location, model);
            result = console.readValidInt("Enter your choice(0 - back): ", model.getProjects().size());
            if (result > 0) {
                Project project = model.getProjects().get(result - 1);
                ProjectController projectController = new ProjectController(project, new ProjectView());
                projectController.showModel(location);
            }
        } while (result != 0);
    }

}
