package org.kudryavtsev.kickstarter;

import java.util.List;

import org.kudryavtsev.kickstarter.data.Category;
import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.inout.Input;
import org.kudryavtsev.kickstarter.inout.View;

public class Controller {
    private Model model;
    private View view;
    private Input input;

    public Controller(Model model, View view, Input input) {
        this.model = model;
        this.view = view;
        this.input = input;
    }

    public void start() {
        model.init();
        view.showGreeting();
        List<Category> categoriesList = model.getCategoriesList();
        processingCategoriesList(categoriesList);
        input.close();
    }

    private void processingCategoriesList(List<Category> categoriesList) {
        while (true) {
            view.showCategories(categoriesList);
            int numberOfCategory = input.getAnswer();
            if (checkNumberOfCategory(categoriesList, numberOfCategory))
                break;
            processingProjectsList(categoriesList, numberOfCategory);
        }
    }

    private boolean checkNumberOfCategory(List<Category> categoriesList, int numberOfCategory) {
        return checkProjectOption(numberOfCategory) == 0 || (numberOfCategory > categoriesList.size());
    }

    private void processingProjectsList(List<Category> categoriesList, int numberOfCategory) {
        while (true) {
            view.showProjects(categoriesList.get(numberOfCategory - 1).getProjectsList());
            int numberOfProject = input.getAnswer();
            if (checkNumberOfProject(categoriesList, numberOfCategory, numberOfProject))
                break;
            processingProject(categoriesList, numberOfCategory, numberOfProject);
        }
    }

    private boolean checkNumberOfProject(List<Category> categoriesList, int numberOfCategory,
            int numberOfProject) {
        return checkProjectOption(numberOfProject) == 0
                || (numberOfProject > categoriesList.get(numberOfCategory - 1).getProjectsList()
                        .size());
    }

    private void processingProject(List<Category> categoriesList, int numberOfCategory,
            int numberOfProject) {
        while (true) {
            view.showProject(categoriesList.get(numberOfCategory - 1).getProjectsList()
                    .get(numberOfProject - 1));
            int projectOption = input.getAnswer();
            if (checkProjectOption(projectOption) == 0) {
                break;
            }
            processingProjectOptions(categoriesList, numberOfCategory, numberOfProject,
                    projectOption);
        }
    }

    private int checkProjectOption(int projectOption) {
        if (projectOption > 2 || projectOption < 1)
            return 0;
        else
            return projectOption;
    }

    private void processingProjectOptions(List<Category> categoriesList, int numberOfCategory,
            int numberOfProject, int projectOption) {
        if (projectOption == 1)
            processingAddInvestment(categoriesList, numberOfCategory, numberOfProject);
        else
            processingAddQuestin(categoriesList, numberOfCategory, numberOfProject);
    }

    private void processingAddQuestin(List<Category> categoriesList, int numberOfCategory,
            int numberOfProject) {
    }

    private void processingAddInvestment(List<Category> categoriesList, int numberOfCategory,
            int numberOfProject) {
    }

}
