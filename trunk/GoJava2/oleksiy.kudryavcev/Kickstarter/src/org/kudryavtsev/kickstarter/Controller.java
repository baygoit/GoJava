package org.kudryavtsev.kickstarter;

import java.util.List;

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
            if ((numberOfCategory == 0) || (numberOfCategory > categoriesList.size()))
                break;
            processingProjectsList(categoriesList, numberOfCategory);
            if (numberOfCategory == 0) {
                break;
            }
        }
    }

    private void processingProjectsList(List<Category> categoriesList, int numberOfCategory) {
        while (true) {
            view.showProjects(categoriesList.get(numberOfCategory - 1).getProjectsList());
            int numberOfProject = input.getAnswer();
            if ((numberOfProject == 0)
                    || (numberOfProject > categoriesList.get(numberOfCategory - 1)
                            .getProjectsList().size()))
                break;
            processingProject(categoriesList, numberOfCategory, numberOfProject);
            if (numberOfProject == 0) {
                break;
            }
        }
    }

    private void processingProject(List<Category> categoriesList, int numberOfCategory,
            int numberOfProject) {
        while (true) {
            view.showProject(categoriesList.get(numberOfCategory - 1).getProjectsList()
                    .get(numberOfProject - 1));
            int projectOption = input.getAnswer();
            if (projectOption != 0) {
                view.show("Selected option: ");
            } else if (projectOption == 0) {
                break;
            }
        }
    }
}
