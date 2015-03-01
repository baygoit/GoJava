package org.kudryavtsev.kickstarter;

import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.in.In;
import org.kudryavtsev.kickstarter.out.View;

public class Controller {
    private Model model;
    private View view;
    private In input;

    public Controller(Model model, View view, In input) {
        this.model = model;
        this.view = view;
        this.input = input;
    }

    public void start() {
        view.showGreeting();
        categoriesList();
        input.close();
    }

    private void categoriesList() {
        while (true) {
            view.showCategories(model.getCategories());

            int category = getNumber();
            if (checkNumberOfCategory(category)){
                break;}
            projectsList(category);
        }
    }

    private int getNumber() {
        int result = input.input();
        if (result == 0) {
            return 0;
        }
        return result - 1;
    }

    private boolean checkNumberOfCategory(int category) {
        return checkProject(category) == 0 || (category > model.categoriesCount());
    }

    private void projectsList(int category) {
        while (true) {
            view.showProjects(model.getCategoryProjects(category).iterator());
            int project = getNumber();
            if (checkNumberOfProject(category, project)) {
                break;
            }
            project(category, project);
        }
    }

    private boolean checkNumberOfProject(int category, int project) {
        if (checkProject(project) == 0) {
            return true;
        }

        return project > model.getCategoryProjects(category).size();
    }

    private void project(int category, int project) {
        while (true) {
            view.showProject(model.getCategoryProjects(category).get(project));
            int projectOption = getNumber();
            if (checkProject(projectOption) == 0) {
                break;
            }
            projectOptions(category, project, projectOption);
        }
    }

    private int checkProject(int projectOption) {
        if (projectOption > 2 || projectOption < 1)
            return 0;
        else {
            return projectOption;
        }
    }

    private void projectOptions(int category, int project, int projectOption) {
        if (projectOption == 1) {
            addInvestment(category, project);
        } else {
            addQuestin(category, project);
        }
    }

    private void addQuestin(int category, int project) {
    }

    private void addInvestment(int category, int project) {
    }

}
