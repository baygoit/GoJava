package com.morkva.ui.views;

import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.controllers.CategoryController;
import com.morkva.ui.controllers.IController;
import com.morkva.ui.controllers.PaymentController;
import com.morkva.ui.controllers.ProjectController;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ProjectView implements IView {

    //TODO попробовать паттерн STATE для админа и гостя!

    Model model;
    Printer printer;
    Reader reader;
    ProjectController controller;

    public ProjectView(Model model, Printer printer, Reader reader, ProjectController controller) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
        this.controller = controller;
    }

    public void showContent() {
        Project project = model.getCurrentProject();
        printer.print(project.getFullInfo());
        switch (model.getCurrentUserType()) {
            case GUEST:
                showGuestFooter();
                break;
            case ADMIN:
                //TODO Realise admin
                System.err.println("Not Realised!");
        }
    }

    public IController readInput() {
        IController result = null;
        switch (model.getCurrentUserType()) {
            case GUEST:
                result = readGuestInput();
                break;
            case ADMIN:
                //TODO Realise admin
                System.err.println("Not Realised!");
                break;
        }
        return result;
    }

    private IController readGuestInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 1) {
                return new PaymentController(model, printer, reader);
            } else if (keyCode == 2) {
                System.err.println("Not Realised!");
//                return ViewType.QUESTION_PAGE;
                //TODO Realise questions!
            } else if (keyCode == 0) {
                return new CategoryController(printer, model, reader);
            } else {
                System.err.println("Wrong Code");
            }
        }
    }

    private void showGuestFooter() {
        printer.print("\n");
        printer.print("1 - Invest to the project\n");
        printer.print("2 - Ask question!");
        printer.print("0 - Exit from project\n");
        printer.print("----------------------------\n");
    }

    private void showAdminFooter() {
        //TODO Realise admin
        System.err.println("Not realised yet!");
    }
}
