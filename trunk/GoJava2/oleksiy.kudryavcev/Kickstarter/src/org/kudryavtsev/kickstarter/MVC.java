package org.kudryavtsev.kickstarter;

public class MVC {
    public MVC() {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();

        controller.addModel(model);
        controller.addView(view);
        model.addView(view);
        System.out.println("MVC created");
        // controller.initModel();
    }
}
