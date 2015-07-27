package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.CategoriesDAO;
import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.ui.Input;
import tyomsky.kickstarter.view.TextView;

import java.util.List;

public class CategoriesMenu extends Menu<Category> {

    CategoriesDAO categoriesDAO;
    List<Category> model;
    TextView view;

    public CategoriesMenu(CategoriesDAO categoriesDAO, Input input, TextView view) {
        super(input);
        this.categoriesDAO = categoriesDAO;
        model = categoriesDAO.getAll();
        this.view = view;
    }


    @Override
    public void ask() {
        askCategories();
    }

    @Override
    public Menu nextMenu(Category selected) {
        ProjectsMenu projectsMenu = (ProjectsMenu) childMenu;
        projectsMenu.setParentCategory(selected);
        return projectsMenu;
    }

    @Override
    public Category select(int chosenMenuIndex) {
        Category selected = selectCategoryByIndex(chosenMenuIndex);
        view.showSelected(selected == null ? "wrong input" : selected.getName());
        return selected;
    }

    private Category selectCategoryByIndex(int index) {
        if (categoryIndexIsInvalid(index)) {
            return null;
        }
        return model.get(index - 1);
    }

    private void askCategories() {
        showCategories();
        view.showInputPrompt();
    }

    private void showCategories() {
        for (int i = 0; i < model.size(); i++) {
            int menuIndex = i + 1;
            view.showMenuElementWithID(model.get(i), String.valueOf(menuIndex));
        }
    }

    private boolean categoryIndexIsInvalid(int chosenMenuIndex) {
        return chosenMenuIndex <= 0 || chosenMenuIndex > model.size();
    }

}
