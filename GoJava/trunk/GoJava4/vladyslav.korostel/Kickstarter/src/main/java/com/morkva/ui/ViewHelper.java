package com.morkva.ui;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.model.Model;
import com.morkva.ui.controllers.*;

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
        controller.readInput();
    }

    public void runCommand() {
        while (true) {
            IController controller = ViewResolver.getInstance().getNextView();
            showView(controller);
        }
    }
}
