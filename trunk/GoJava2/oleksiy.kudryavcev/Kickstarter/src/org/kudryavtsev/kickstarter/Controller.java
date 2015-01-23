package org.kudryavtsev.kickstarter;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
//        model = null;
//        view = null;
        System.out.println("Controller created");
    }

    public void addModel(Model model) {
        this.model = model;
        System.out.println("Controller added model");
    }

    public void addView(View view) {
        this.view = view;
        System.out.println("Controller added view");

    }

    public void initModel() {
        // TODO Auto-generated method stub

    }

}
