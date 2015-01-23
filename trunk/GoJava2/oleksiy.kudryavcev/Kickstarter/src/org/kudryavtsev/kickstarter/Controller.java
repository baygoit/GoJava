package org.kudryavtsev.kickstarter;

import java.util.Locale.Category;

public class Controller {
    private Model model;
    private View view;

    // private boolean exit;

    public Controller() {
        // System.out.println("Controller created");
        // exit = false;
    }

    public void addModel(Model model) {
        this.model = model;
        // System.out.println("Controller added model");
    }

    public void addView(View view) {
        this.view = view;
        // System.out.println("Controller added view");
    }

    public void start() {
        model.init(10);
        view.show();
        view.showCategories(model.getCategoryList());
        
    }

}
