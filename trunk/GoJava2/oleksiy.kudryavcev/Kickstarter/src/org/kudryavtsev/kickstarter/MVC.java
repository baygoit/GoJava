package org.kudryavtsev.kickstarter;

public class MVC {
    public MVC() {
        Out whereToOut = new OutArrayList();
//        Out whereToOut = new OutConsole();
        In whereToIn = new InArrayList();
//        In whereToIn = new InConsole();
        
        Model model = new Model();
        View view = new View(whereToOut);
        Input scan = new Input(whereToIn);
        Controller controller = new Controller(model, view, scan);

        controller.start();
    }
}
