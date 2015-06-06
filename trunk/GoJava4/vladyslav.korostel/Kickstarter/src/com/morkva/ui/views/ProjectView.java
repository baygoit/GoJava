package com.morkva.ui.views;

import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.controllers.ProjectController;
import com.morkva.ui.views.states.AuthState;
import com.morkva.ui.views.states.ProjectGuestState;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ProjectView implements IView {

    Model model;
    Printer printer;
    Reader reader;
    ProjectController controller;
    AuthState state;

    public ProjectView(Model model, Printer printer, Reader reader, ProjectController controller) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
        this.controller = controller;

        switch (model.getCurrentUserType()) {
            case GUEST:
                setState(new ProjectGuestState(model, this, printer, reader));
                break;
            case ADMIN:
                printer.print("Not realised!");
                //TODO Realise admin
                System.err.println("Not Realised!");
        }
    }

    public void readInput() {
        state.readInput();
    }

    public void showContent() {
        Project project = model.getCurrentProject();
        printer.print(project.getFullInfo());
        state.showFooter();
    }


    public void setState(AuthState state) {
        this.state = state;
    }
}
