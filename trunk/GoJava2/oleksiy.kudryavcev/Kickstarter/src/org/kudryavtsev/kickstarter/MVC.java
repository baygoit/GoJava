package org.kudryavtsev.kickstarter;

public class MVC {
    public MVC() {
        Model model = new Model();
        View view = new View();
        Scan scan = new Scan();
        Controller controller = new Controller(model, view, scan);

        controller.start();
    }
}
