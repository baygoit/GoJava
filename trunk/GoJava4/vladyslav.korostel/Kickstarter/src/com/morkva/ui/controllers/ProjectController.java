package com.morkva.ui.controllers;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.CommandType;
import com.morkva.ui.Model;
import com.morkva.ui.views.ProjectView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ProjectController {

    private Model model;
    private ProjectView view;
    private Reader reader;

    public ProjectController(Printer printer, Model model, Reader reader) {
        this.reader = reader;
        this.view = new ProjectView(model, printer);
        this.model = model;
        this.model.setCurrentCategory(model.getCurrentCategory());
    }

    public void showView() {
        view.show();
    }

    public CommandType readInput() {
        CommandType command;
        int keyCode = reader.readUserInput();
        if (keyCode == 0) {
            command = CommandType.EXIT_FROM_PROJECT;
        } else {
            command = CommandType.DEFAULT_COMMAND;
        }
        return command;
    }
}
