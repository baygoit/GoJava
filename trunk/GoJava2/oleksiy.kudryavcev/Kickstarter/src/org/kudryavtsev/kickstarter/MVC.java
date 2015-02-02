package org.kudryavtsev.kickstarter;

import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.inout.In;
import org.kudryavtsev.kickstarter.inout.InArrayList;
import org.kudryavtsev.kickstarter.inout.Input;
import org.kudryavtsev.kickstarter.inout.Out;
import org.kudryavtsev.kickstarter.inout.OutArrayList;
import org.kudryavtsev.kickstarter.inout.View;

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
