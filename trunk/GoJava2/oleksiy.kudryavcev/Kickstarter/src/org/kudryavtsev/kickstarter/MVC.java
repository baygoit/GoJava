package org.kudryavtsev.kickstarter;

import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.in.In;
import org.kudryavtsev.kickstarter.in.InArrayList;
import org.kudryavtsev.kickstarter.in.Input;
import org.kudryavtsev.kickstarter.out.Out;
import org.kudryavtsev.kickstarter.out.OutArrayList;
import org.kudryavtsev.kickstarter.out.View;

public class MVC {
    public MVC() {
        Out whereToOut = new OutArrayList();
        In whereToIn = new InArrayList();
        
        Model model = new Model();
        View view = new View(whereToOut);
        Input input = new Input(whereToIn);
        Controller controller = new Controller(model, view, input);

        controller.start();
    }
}
