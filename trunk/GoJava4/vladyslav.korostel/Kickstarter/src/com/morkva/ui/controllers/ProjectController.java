package com.morkva.ui.controllers;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.views.ProjectView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ProjectController implements IController{

    private ProjectView view;

    public ProjectController(Printer printer, Model model, Reader reader) {
        this.view = new ProjectView(model, printer, reader, this);
    }

    public void showView() {
        view.showContent();
    }

    public IController readInput() {
        return view.readInput();
    }


}
