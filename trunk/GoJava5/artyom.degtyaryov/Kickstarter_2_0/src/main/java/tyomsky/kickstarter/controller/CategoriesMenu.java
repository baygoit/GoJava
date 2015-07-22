package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.CategoriesDAO;
import tyomsky.kickstarter.dao.Projects;
import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.IO;

import java.util.ArrayList;
import java.util.List;

public class CategoriesMenu extends Menu {

    CategoriesDAO categories;
    Projects projects;

    public CategoriesMenu(CategoriesDAO categories, Projects projects, IO io) {
        super(io);
        this.categories = categories;
        this.projects = projects;
    }

    @Override
    public Menu nextMenu(Object selected) {
        List<Project> foundProjects = getProjetsByCategory((Category) selected);
        return new ProjectsMenu(foundProjects, io);
    }

    @Override
    public Object select(int chosenMenuIndex) {
        return chooseCategory(chosenMenuIndex);
    }

    @Override
    public void ask() {
        askCategories();
    }

    private Category chooseCategory(int chosenMenuIndex) {
        if (categoryIndexIsInvalid(chosenMenuIndex)) {
            io.println("You have chosen wrong menu index " + chosenMenuIndex);
            return null;
        }
        Category chosenCategory = categories.get(chosenMenuIndex - 1);
        io.println("You have chosen: " + chosenCategory.getName());
        io.println("------------------------------------------------------");
        return chosenCategory;
    }

    private void askCategories() {
        showCategories();
        io.println("Select item (0 for exit)");
    }

    private void showCategories() {
        for (int i = 0; i < categories.size(); i++) {
            int menuIndex = i + 1;
            io.println(menuIndex + ": " + categories.get(i).getName());
        }
    }

    private boolean categoryIndexIsInvalid(int chosenMenuIndex) {
        return chosenMenuIndex <= 0 || chosenMenuIndex > categories.size();
    }

    private List<Project> getProjetsByCategory(Category category) {
        List<Project> result = new ArrayList<>();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getCategory().equals(category)) {
                result.add(projects.get(i));
            }
        }
        return result;
    }

}
