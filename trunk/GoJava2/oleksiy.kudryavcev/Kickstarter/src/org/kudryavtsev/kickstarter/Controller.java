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
        List<Project> list = model.getCategoriesList();

        boolean exit = false;
        while (!exit) {
            view.showCategories(list);
            int result = scan.getAnswer();
            if (result > 0 && result <= list.size()) {
                view.showProjectsInCategory(list, list.get(result - 1).getCategory());
                // view.showCategories(result - 1, list);
            } else
                exit = true;
        }
        scan.close();
    }
}
