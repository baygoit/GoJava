package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.ProjectsDAO;
import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.Input;
import tyomsky.kickstarter.view.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProjectsMenu extends Menu<Project> {

    private ProjectsDAO projectsDAO;
    List<Project> model;
    TextView view;

    public ProjectsMenu(ProjectsDAO projectsDAO, Input input, TextView view) {
        super(input);
        this.projectsDAO = projectsDAO;
        this.model = new ArrayList<>();
        this.view = view;
    }

    @Override
    public Menu nextMenu(Project selected) {
        ProjectMenu projectMenu = (ProjectMenu) childMenu;
        projectMenu.setModel(selected);
        return projectMenu;
    }

    @Override
    public Project select(int chosenMenuIndex) {
        Project selected = selectProjectByIndex(chosenMenuIndex);
        view.showSelected(selected == null? "wrong input": selected.getName());
        return selected;
    }

    @Override
    public void ask() {
        askProjects();
    }

    private Project selectProjectByIndex(int chosenMenuIndex) {
        if (projectIndexIsInvalid(chosenMenuIndex)) {
            return null; // or nil
        }
        return model.get(chosenMenuIndex - 1);
    }

    private boolean projectIndexIsInvalid(int chosenMenuIndex) {
        return chosenMenuIndex <= 0 || chosenMenuIndex > model.size();
    }

    private void askProjects() {
        showProjects();
        view.showInputPrompt();
    }

    private void showProjects() {
        for (int i = 0; i < model.size(); i++) {
            Project project = model.get(i);
            int menuIndex = i + 1;
            view.showMenuElementWithID(project, String.valueOf(menuIndex));
        }
    }

    private List<Project> getProjectsByCategory(Category category) {
        List<Project> result = new ArrayList<>();
        for (int i = 0; i < projectsDAO.size(); i++) {
            if (projectsDAO.get(i).getCategory().equals(category)) {
                result.add(projectsDAO.get(i));
            }
        }
        return result;
    }

    public void setParentCategory(Category parentCategory) {
        if (parentCategory != null) {
            this.model = getProjectsByCategory(parentCategory);
        }
    }
}
