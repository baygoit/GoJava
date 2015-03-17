package org.kudryavtsev.kickstarter;

import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.in.In;
import org.kudryavtsev.kickstarter.out.View;

public class Controller {
    private static final int SHIFT = 1;
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
            int category = getAnswer();
            view.show(Integer.toString(category));
            if (correctAnswer(category, model.categoriesCount())) {
                projectsList(category - SHIFT);
            } else {
                break;
            }
        }
    }

    private int getAnswer() {
        return input.input();
    }

    private boolean correctAnswer(int index, int count) {
        if (index <= 0) {
            return false;
        }
        if (index > count) {
            return false;
        }
        return true;
    }

    private void projectsList(int category) {
        while (true) {
            view.showProjects(model.getCategoryProjects(category).iterator());
            int project = getAnswer();
            view.show(Integer.toString(project));
            if (correctAnswer(project, model.getCategoryProjects(category).size())) {
                project(category, project - SHIFT);
            } else {
                break;
            }
        }
    }

    private void project(int category, int project) {
        while (true) {
            view.showProject(model.getCategoryProjects(category).get(project));
            int projectOption = getAnswer();
            view.show(Integer.toString(projectOption));
            if (checkProject(projectOption) == 0) {
                break;
                //TODO implement correctAnswer method
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
        //TODO implement questions
    }

    private void addInvestment(int category, int project) {
        //TODO implement investing
    }

}
