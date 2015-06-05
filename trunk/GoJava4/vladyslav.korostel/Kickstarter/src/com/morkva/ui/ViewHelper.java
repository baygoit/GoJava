package com.morkva.ui;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.controllers.*;
import com.morkva.ui.views.IView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ViewHelper {

    Model model;
    Printer printer;
    Reader reader;

    public ViewHelper(Model model, Printer printer, Reader reader) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
    }

    public void showView(IController controller) {
        controller.showView();
        ViewResolver.getInstance().setNextView(controller.readInput());
    }

    public void runCommand() {
        while (true) {
            IController controller = ViewResolver.getInstance().getNextView();
            showView(controller);
        }
    }
}
