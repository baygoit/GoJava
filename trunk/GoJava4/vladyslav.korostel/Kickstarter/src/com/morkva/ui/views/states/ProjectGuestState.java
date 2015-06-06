package com.morkva.ui.views.states;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.ViewResolver;
import com.morkva.ui.controllers.CategoryController;
import com.morkva.ui.controllers.IController;
import com.morkva.ui.controllers.PaymentController;
import com.morkva.ui.views.ProjectView;

/**
 * Created by vladyslav on 01.06.15.
 */
public class ProjectGuestState implements AuthState {

    ProjectView view;
    Printer printer;
    Reader reader;
    Model model;

    public ProjectGuestState(Model model, ProjectView view, Printer printer, Reader reader) {
        this.view = view;
        this.printer = printer;
        this.reader = reader;
        this.model = model;
    }

    @Override
    public void showFooter() {
        printer.print("\n");
        printer.print("1 - Invest to the project\n");
        printer.print("2 - Ask question!");
        printer.print("0 - Exit from project\n");
        printer.print("----------------------------\n");
    }

    @Override
    public void readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 1) {
                ViewResolver.getInstance().setNextView(new PaymentController(model, printer, reader));
                break;
            } else if (keyCode == 2) {
                System.err.println("Not Realised!");
                //TODO Realise questions!
            } else if (keyCode == 0) {
                ViewResolver.getInstance().setNextView(new CategoryController(printer, model, reader));
                break;
            } else {
                System.err.println("Wrong Code");
            }
        }
    }
}
