package org.kudryavtsev.kickstarter;

public class MVC {
    public MVC() {
        Out whereToOut = new OutArrayList();
        Model model = new Model();
        View view = new View(whereToOut);
        Scan scan = new Scan();
        Controller controller = new Controller(model, view, scan);

        controller.start();
    }
}
