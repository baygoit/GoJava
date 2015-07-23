package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.view.CategoryView;

import static java.lang.Integer.parseInt;

public class CategoryController extends BaseController {
    private Category model;
    private CategoryView view;
    private int categoryId;
    private ProjectController projectController;

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setProjectController(ProjectController projectController) {
        this.projectController = projectController;
    }

    public void setView(CategoryView view) {
        this.view = view;
    }

    public void updateModel() {
        model = dataProvider.getCategory(categoryId);
    }

    private boolean isValid(String input) {
        try {
            int inputValue = parseInt(input);
            return !(inputValue < 1 || inputValue > model.getProjects().size());
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getProjectId(String input) {
        return model.getProjects().get(parseInt(input) - 1).getId();
    }

    @Override
    public void showModel() {
        updateModel();
        onShowModel();
        view.render(model);
    }

    @Deprecated
    @Override
    public int getModelIdentifier() {
        return 0;
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            projectController.setProjectId(getProjectId(input));
            setNextController(projectController);
        } else {
            setNextController(this);
        }
    }
}
