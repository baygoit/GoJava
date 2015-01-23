package org.kudryavtsev.kickstarter;

public class Model {
    private View view;

    public Model() {
        System.out.println("Model created");
    }

    public void addView(View view) {
        this.view = view;
        System.out.println("Model added view");
    }

}
