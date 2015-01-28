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
        List<Project> list = model.getProjectsList();
        List<Category> categoryList = model.getCategoriesList();

        boolean exitFromApplication = false;
        while (!exitFromApplication) {
            view.showCategories(categoryList);
            int numberOfCategory = scan.getAnswer();
            boolean exitFromCategories = false;
            while (!exitFromCategories) {
                view.showProjects(categoryList.get(numberOfCategory - 1).getProjectsList());
                int numberOfProject = scan.getAnswer();
                boolean exitFromProject = false;
                // while(!exitFromProject){
                // int projectOption = scan.getAnswer();
                // if (projectOption != 0){
                view.showProject(categoryList.get(numberOfCategory - 1).getProjectsList()
                        .get(numberOfProject - 1));
                // }else
                // exitFromProject = true;

                // }
                exitFromCategories = true;
            }
            exitFromApplication = true;
        }
       scan.close();
    }
}
