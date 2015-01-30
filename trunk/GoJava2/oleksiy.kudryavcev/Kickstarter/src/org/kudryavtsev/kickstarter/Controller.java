package org.kudryavtsev.kickstarter;

import java.util.List;

public class Controller {
    private Model model;
    private View view;
    private Scan scan;

    public Controller(Model model, View view, Scan scan) {
        this.model = model;
        this.view = view;
        this.scan = scan;
    }

    public void start() {
        model.init();
        view.showGreeting();
        List<Project> projectsList = model.getProjectsList();
        List<Category> categoriesList = model.getCategoriesList();

        boolean exitFromApplication = false;
        while (!exitFromApplication) {
            view.showCategories(categoriesList);
            int numberOfCategory = scan.getAnswer();
            if (numberOfCategory == 0)
                break;
            boolean exitFromCategories = false;
            while (!exitFromCategories) {
                view.showProjects(categoriesList.get(numberOfCategory - 1).getProjectsList());
                int numberOfProject = scan.getAnswer();
                if (numberOfProject == 0)
                    break;
                boolean exitFromProject = false;
                while (!exitFromProject) {
                    view.showProject(categoriesList.get(numberOfCategory - 1).getProjectsList()
                            .get(numberOfProject - 1));
                    view.showProjectMenu();
                    int projectOption = scan.getAnswer();
                    if (projectOption != 0) {
                        System.out.println("Selected option: ");
                    } else
                        System.out.println("Exiting from project");
                    exitFromProject = true;
                }
                if (numberOfProject == 0) {
                    System.out.println("Exiting from categories");
                    exitFromCategories = true;
                }
            }
            if (numberOfCategory == 0) {
                System.out.println("Exiting from application");
                exitFromApplication = true;
            }
        }
        scan.close();
    }
}
