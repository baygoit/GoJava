package com.morkva.ui.views;

import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.ViewType;
import com.morkva.ui.controllers.ProjectController;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ProjectView implements IView{

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
        showFooter();
    }

    private void showInvest() {
        printer.print("How much do you want to invest?");
        int amount = reader.readUserInput();
        controller.investToTheProject(amount);
        printer.print("Thank you for investment!");
        showContent();
    }

    public ViewType readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 1) {
                showInvest();
            } else if (keyCode == 0) {
                return ViewType.CATEGORY_PAGE;
            } else {
                System.err.println("Wrong Code");
            }
        }
    }

    private void showFooter() {
        printer.print("\n");
        printer.print("1 - Invest to the project\n");
        printer.print("0 - Exit from project\n");
        printer.print("----------------------------\n");
    }
}
