package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.view.CategoryView;

import static java.lang.Integer.parseInt;

public class CategoryController extends AbstractController {
    private Category model;
    private CategoryView view;
    private int categoryId;
    private ProjectController projectController;

    public CategoryController(DataProvider dataProvider) {
        super(dataProvider);
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setModel(Category model) {
        this.model = model;
    }

    public void setProjectController(ProjectController projectController) {
        this.projectController = projectController;
    }

    public void setView(CategoryView view) {
        this.view = view;
    }

    public int getProjectId(String input) {
        return model.getProjects().get(parseInt(input) - 1).getId();
    }

    @Override
    public void updateModel() {
        model = dataProvider.getCategory(categoryId);
    }

    @Override
    protected boolean isValid(String input) {
        try {
            int inputValue = parseInt(input);
            return !(inputValue < 1 || inputValue > model.getProjects().size());
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void renderModel() {
        view.render(model);
    }

    @Override
    protected void doValidControl(String input) {
        projectController.setProjectId(getProjectId(input));
        setNextController(projectController);
    }

    @Override
    protected void showError(String input) {
    }
}
