package org.kudryavtsev.kickstarter;

public class MVC {
    public MVC() {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();
        Scan scan = new Scan();

        controller.add(model, view, scan);
        controller.start();
    }
}
